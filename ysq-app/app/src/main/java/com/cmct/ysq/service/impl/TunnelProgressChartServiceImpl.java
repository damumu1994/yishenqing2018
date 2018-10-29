package com.cmct.ysq.service.impl;

import com.cmct.base.constant.DeleteStatus;
import com.cmct.common.util.ValidateUtil;
import com.cmct.ysq.common.ConstructMethod;
import com.cmct.ysq.common.DirConstants;
import com.cmct.ysq.mapper.*;
import com.cmct.ysq.model.po.*;
import com.cmct.ysq.model.vo.*;
import com.cmct.ysq.service.ITunnelProgressChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.cmct.ysq.util.EncacheUtil.getSysParamCode;
import static com.cmct.ysq.util.EncacheUtil.getSysParamName;

/**
 * @author 1
 */
@Service
public class TunnelProgressChartServiceImpl implements ITunnelProgressChartService {

    @Autowired
    private TunnelConsInfoMapper tunnelConsInfoMapper;

    @Autowired
    private TunnelInfoMapper tunnelInfoMapper;

    @Autowired
    private SysParamMapper sysParamMapper;

    @Autowired
    private TunnelProParamLinkMapper tunnelProParamLinkMapper;

    @Autowired
    private TunnelConsProgressMapper tunnelConsProgressMapper;

    @Autowired
    private TunnelProgCdMapper tunnelProgCdMapper;

    @Autowired
    private TunnelProgPitMapper tunnelProgPitMapper;

    @Autowired
    private TunnelProgTwoStepMapper tunnelProgTwoStepMapper;

    @Autowired
    private TunnelProgFullFaceMapper tunnelProgFullFaceMapper;

    @Autowired
    private TunnelProgThreeStepMapper tunnelProgThreeStepMapper;

    @Autowired
    private TunnelProgLinerMapper tunnelProgLinerMapper;

    public static void main(String[] args) {
        List<BigDecimal> result = Arrays.asList(TunnelProgLinerPo.builder()
                        .build(),
                TunnelProgLinerPo.builder()
                        .build(),
                TunnelProgLinerPo.builder()
                        .build(),
                TunnelProgLinerPo.builder()
                        .build())
                .parallelStream()
                .flatMap((Function<TunnelProgLinerPo, Stream<BigDecimal>>) tunnelProgLinerPo -> {
                    if (tunnelProgLinerPo.getFacePegNoStart() != null && tunnelProgLinerPo.getFacePegNoEnd() != null) {
                        return Stream.of(tunnelProgLinerPo.getFacePegNoStart(), tunnelProgLinerPo.getFacePegNoEnd());
                    }
                    if (tunnelProgLinerPo.getFacePegNoStart() != null && tunnelProgLinerPo.getFacePegNoEnd() == null) {
                        return Stream.of(tunnelProgLinerPo.getFacePegNoStart());
                    }
                    if (tunnelProgLinerPo.getFacePegNoStart() == null && tunnelProgLinerPo.getFacePegNoEnd() != null) {
                        return Stream.of(tunnelProgLinerPo.getFacePegNoEnd());
                    }
                    return Stream.empty();

                })
                .sorted((o1, o2) -> {
                    if (o1 == o2) {
                        return 0;
                    }
                    if (o1 == null) {
                        return -1;
                    }

                    if (o2 == null) {
                        return 1;
                    }

                    return o1.subtract(o2).intValue();
                })
                .collect(Collectors.toList());

        System.out.println(result);
    }

    @Override
    public List<TunnelProgressVo> getTunnelProgresss(String userId) {

        //权限部分原因 todo
        TunnelInfoPo tunnelInfoPo = TunnelInfoPo.builder().build();

        //判断是否配置正确了方向和洞别
        List<SysParamVo> holes = tunnelInfoMapper.getTunnelDirOrHoleInfo(tunnelInfoPo.getTunnelProId(),
                Arrays.asList(DirConstants.CODE_TUNNEL_HOLE));

        if (CollectionUtils.isEmpty(holes)) {
            return null;
        }

        List<SysParamVo> dirs = tunnelInfoMapper.getTunnelDirOrHoleInfo(tunnelInfoPo.getTunnelProId(),
                Arrays.asList(DirConstants.CODE_TUNNEL_DIR_IN, DirConstants.CODE_TUNNEL_DIR_OUT));

        if (CollectionUtils.isEmpty(dirs)) {
            return null;
        }

        //包装实体
        Map<String, TunnelProgressVo> holeIdMap = new HashMap(16);

        List<TunnelProgressVo> resultVo = holes.stream()
                .map(sysParamVo -> {
                    TunnelProgressVo tunnelProgressVo = TunnelProgressVo.builder()
                            .tunnelId(tunnelInfoPo.getTunnelProId())
                            .tunnelName(tunnelInfoPo.getTunnelName())
                            .holeId(sysParamVo.getParamId())
                            .holeName(sysParamVo.getParamName())
                            .tunnelSurInfos(new ArrayList<>())
                            .tunnelProgressDetails(new ArrayList<>())
                            .build();
                    holeIdMap.put(sysParamVo.getParamId(), tunnelProgressVo);
                    return tunnelProgressVo;
                })
                .collect(Collectors.toList());

        //围岩
        Example ex = new Example(TunnelConsInfoPo.class);
        ex.createCriteria()
                .andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                .andEqualTo("tunnelId", tunnelInfoPo.getTunnelProId());
        List<TunnelConsInfoPo> tunnelConsInfoPos = tunnelConsInfoMapper.selectByExample(ex);

        if (!CollectionUtils.isEmpty(tunnelConsInfoPos)) {
            for (TunnelConsInfoPo tunnelConsInfoPo : tunnelConsInfoPos) {
                TunnelProgressVo tunnelProgressVo = holeIdMap.get(tunnelConsInfoPo.getTunnelHoleLinkId());

                tunnelProgressVo.getTunnelSurInfos().add(TunnelSurInfoVo.builder()
                        .levelId(tunnelConsInfoPo.getLevelId())
                        .levelName(getSysParamName(tunnelConsInfoPo.getLevelId()))
                        .pegStart(tunnelConsInfoPo.getPegStart())
                        .pegEnd(tunnelConsInfoPo.getPegEnd())
                        .build());
            }
        }

        //进度图详情数据
        holeIdMap.values().stream().forEach(tunnelProgressVo ->
                tunnelProgressVo.getTunnelProgressDetails().addAll(dirs.stream().map(sysParamVo -> TunnelProgressDetailVo.builder()
                        .tunnelDirId(sysParamVo.getParamId())
                        .tunnelDirName(sysParamVo.getParamName())
                        .tunnelProgressGeoForcasts(new ArrayList<>())
                        .build())
                        .collect(Collectors.toList())));

        //施工进度信息
        for (TunnelProgressVo tunnelProgressVo : resultVo) {
            tunnelProgressVo.getTunnelProgressDetails().forEach(tunnelProgressDetailVo -> {

                //最新掌子面面

                TunnelConsProgressPo neweastConsProgress = tunnelConsProgressMapper.getNewestFaceDistance(tunnelInfoPo.getTunnelProId(),
                        tunnelProgressDetailVo.getTunnelDirId(),
                        tunnelProgressVo.getHoleId());

                if (neweastConsProgress == null) {
                    return;
                }

                String[] neweastLinearId = new String[1];
                Example ex1 = null;
                BigDecimal neweasetFaceProgress = BigDecimal.ZERO;
                BigDecimal neweasetBottomAccumulationLengthProgress = BigDecimal.ZERO;
                switch (ConstructMethod.getConstructMethod(neweastConsProgress.getMethod())) {
                    case CD:
                        ex1 = new Example(TunnelProgCdPo.class);
                        ex1.createCriteria()
                                .andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                .andEqualTo("prgId", neweastConsProgress.getConstructProgressId());
                        Optional.ofNullable(tunnelProgCdMapper.selectByExample(ex1))
                                .ifPresent(tunnelProgCdPos -> {
                                    TunnelProgCdPo neweastCdPo = tunnelProgCdPos.get(0);
                                    List<BigDecimal> sortedBigdecimal = Arrays.asList(neweastCdPo.getLeftWallOnePegNoEnd(),
                                            neweastCdPo.getLeftWallOnePegNoStart(), neweastCdPo.getLeftWallTwoPegNoStart(),
                                            neweastCdPo.getLeftWallTwoPegNoEnd(), neweastCdPo.getLeftWallThreePegNoEnd(),
                                            neweastCdPo.getLeftWallTwoPegNoStart(), neweastCdPo.getRightWallOnePegNoEnd(),
                                            neweastCdPo.getRightWallOnePegNoStart(), neweastCdPo.getRightWallTwoPegNoStart(),
                                            neweastCdPo.getRightWallTwoPegNoEnd(), neweastCdPo.getRightWallThreePegNoEnd(),
                                            neweastCdPo.getRightWallTwoPegNoStart())
                                            .parallelStream()
                                            .filter(bigDecimal -> bigDecimal != null)
                                            .sorted(getBigDecimalComparator())
                                            .collect(Collectors.toList());

                                    List<BigDecimal> sortedBottomAccumulationLengthBigdecimal = Arrays.asList(neweastCdPo.getBottomPegNoStart(), neweastCdPo.getBottomPegNoEnd())
                                            .stream().filter(bigDecimal -> bigDecimal != null)
                                            .sorted(getBigDecimalComparator())
                                            .collect(Collectors.toList());

                                    //获取二衬
                                    List<TunnelProgLinerPo> neweastTunnelProgLinerPos = tunnelProgLinerMapper.select(TunnelProgLinerPo.builder()
                                            .prgRecordId(neweastCdPo.getTunnelProgCdId())
                                            .deleteStatus(DeleteStatus.YES.ordinal())
                                            .build());

                                    neweastLinearId[0] = neweastCdPo.getTunnelProgCdId();
                                    getNeweastProgress(tunnelProgressDetailVo, neweasetFaceProgress, neweasetBottomAccumulationLengthProgress, sortedBigdecimal, sortedBottomAccumulationLengthBigdecimal);
                                });

                        break;
                    case PIT:
                        ex1 = new Example(TunnelProgPitPo.class);
                        ex1.createCriteria()
                                .andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                .andEqualTo("prgId", neweastConsProgress.getConstructProgressId());
                        Optional.ofNullable(tunnelProgPitMapper.selectByExample(ex1))
                                .ifPresent(tunnelProgPitPos -> {
                                    TunnelProgPitPo neweastPitPo = tunnelProgPitPos.get(0);
                                    List<BigDecimal> sortedBigdecimal = Arrays.asList(neweastPitPo.getLeftWallOnePegNoEnd(),
                                            neweastPitPo.getLeftWallOnePegNoStart(), neweastPitPo.getLeftWallTwoPegNoStart(),
                                            neweastPitPo.getLeftWallTwoPegNoEnd(), neweastPitPo.getMiddleWallFivePegNoStart(),
                                            neweastPitPo.getLeftWallTwoPegNoStart(), neweastPitPo.getMiddleWallFivePegNoEnd(),
                                            neweastPitPo.getMiddleWallSixPegNoStart(), neweastPitPo.getMiddleWallSixPegNoEnd(),
                                            neweastPitPo.getRightWallFourPegNoStart(), neweastPitPo.getRightWallThreePegNoEnd(),
                                            neweastPitPo.getRightWallFourPegNoEnd())
                                            .parallelStream()
                                            .filter(bigDecimal -> bigDecimal != null)
                                            .sorted(getBigDecimalComparator())
                                            .collect(Collectors.toList());

                                    List<BigDecimal> sortedBottomAccumulationLengthBigdecimal = Arrays.asList(neweastPitPo.getBottomPegNoStart(), neweastPitPo.getBottomPegNoEnd())
                                            .stream().filter(bigDecimal -> bigDecimal != null)
                                            .sorted(getBigDecimalComparator())
                                            .collect(Collectors.toList());

                                    neweastLinearId[0] = neweastPitPo.getPrgPitId();
                                    getNeweastProgress(tunnelProgressDetailVo, neweasetFaceProgress, neweasetBottomAccumulationLengthProgress, sortedBigdecimal, sortedBottomAccumulationLengthBigdecimal);
                                });
                        break;
                    case TWO_STEP:
                        ex1 = new Example(TunnelProgTwoStepPo.class);
                        ex1.createCriteria()
                                .andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                .andEqualTo("prgId", neweastConsProgress.getConstructProgressId());
                        Optional.ofNullable(tunnelProgTwoStepMapper.selectByExample(ex1))
                                .ifPresent(tunnelProgTwoStepPos -> {
                                    TunnelProgTwoStepPo neweastTwoStepPo = tunnelProgTwoStepPos.get(0);
                                    List<BigDecimal> sortedBigdecimal = Arrays.asList(neweastTwoStepPo.getUpStepPegNoStart(),
                                            neweastTwoStepPo.getUpStepSegNoNd(), neweastTwoStepPo.getDownStepPegNoStart(),
                                            neweastTwoStepPo.getDownStepPegNoEnd())
                                            .parallelStream()
                                            .filter(bigDecimal -> bigDecimal != null)
                                            .sorted(getBigDecimalComparator())
                                            .collect(Collectors.toList());


                                    neweastLinearId[0] = neweastTwoStepPo.getPrgTwoStepId();

                                    List<BigDecimal> sortedBottomAccumulationLengthBigdecimal = Arrays.asList(neweastTwoStepPo.getBottomPegNoStart(), neweastTwoStepPo.getBottomPegNoEnd())
                                            .stream().filter(bigDecimal -> bigDecimal != null)
                                            .sorted(getBigDecimalComparator())
                                            .collect(Collectors.toList());

                                    getNeweastProgress(tunnelProgressDetailVo, neweasetFaceProgress, neweasetBottomAccumulationLengthProgress, sortedBigdecimal, sortedBottomAccumulationLengthBigdecimal);
                                });
                        break;
                    case FULL_FACE:
                        ex1 = new Example(TunnelProgFullFacePo.class);
                        ex1.createCriteria()
                                .andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                .andEqualTo("consProgId", neweastConsProgress.getConstructProgressId());
                        Optional.ofNullable(tunnelProgFullFaceMapper.selectByExample(ex1))
                                .ifPresent(tunnelProgTwoStepPos -> {
                                    TunnelProgFullFacePo neweastFullFacePo = tunnelProgTwoStepPos.get(0);
                                    List<BigDecimal> sortedBigdecimal = Arrays.asList(neweastFullFacePo.getFacePegNoStart(),
                                            neweastFullFacePo.getFacePegNoStart())
                                            .parallelStream()
                                            .filter(bigDecimal -> bigDecimal != null)
                                            .sorted(getBigDecimalComparator())
                                            .collect(Collectors.toList());

                                    neweastLinearId[0] = neweastFullFacePo.getConsProgId();

                                    List<BigDecimal> sortedBottomAccumulationLengthBigdecimal = Arrays.asList(neweastFullFacePo.getBottomPegNoStart(), neweastFullFacePo.getBottomPegNoEnd())
                                            .stream().filter(bigDecimal -> bigDecimal != null)
                                            .sorted(getBigDecimalComparator())
                                            .collect(Collectors.toList());

                                    getNeweastProgress(tunnelProgressDetailVo, neweasetFaceProgress, neweasetBottomAccumulationLengthProgress, sortedBigdecimal, sortedBottomAccumulationLengthBigdecimal);
                                });
                        break;
                    case THREE_STEP:
                        ex1 = new Example(TunnelProgFullFacePo.class);
                        ex1.createCriteria()
                                .andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                .andEqualTo("consProgId", neweastConsProgress.getConstructProgressId());
                        Optional.ofNullable(tunnelProgThreeStepMapper.selectByExample(ex1))
                                .ifPresent(tunnelProgTwoStepPos -> {
                                    TunnelProgThreeStepPo neweastThreeStepPo = tunnelProgTwoStepPos.get(0);
                                    List<BigDecimal> sortedBigdecimal = Arrays.asList(neweastThreeStepPo.getUpStepPegNoStart(),
                                            neweastThreeStepPo.getUpStepPegNoEnd(), neweastThreeStepPo.getMiddleStepPegNoStart(),
                                            neweastThreeStepPo.getMiddleStepPegNoEnd(), neweastThreeStepPo.getDownStepPegNoStart(),
                                            neweastThreeStepPo.getDownStepPegNoEnd())
                                            .parallelStream()
                                            .filter(bigDecimal -> bigDecimal != null)
                                            .sorted(getBigDecimalComparator())
                                            .collect(Collectors.toList());

                                    neweastLinearId[0] = neweastThreeStepPo.getPrgThreeStepId();

                                    List<BigDecimal> sortedBottomAccumulationLengthBigdecimal = Arrays.asList(neweastThreeStepPo.getBottomPegNoStart(), neweastThreeStepPo.getBottomPegNoEnd())
                                            .stream().filter(bigDecimal -> bigDecimal != null)
                                            .sorted(getBigDecimalComparator())
                                            .collect(Collectors.toList());

                                    getNeweastProgress(tunnelProgressDetailVo, neweasetFaceProgress, neweasetBottomAccumulationLengthProgress, sortedBigdecimal, sortedBottomAccumulationLengthBigdecimal);
                                });
                        break;
                    default:
                        break;
                }

                tunnelProgressDetailVo.setTunnelMonitorProgress(TunnelMonitorProgressVo.builder()
                        .faceDistance(neweasetFaceProgress)
                        .facePegNoEnd(getNeweastLinear(neweastLinearId[0], tunnelProgressDetailVo.getTunnelDirId()))
                        .invertedArchOrTunnelBottom(neweasetBottomAccumulationLengthProgress)
                        .build());
            });
        }

        return resultVo;
    }

    /**
     * 获取最新施工进度信息
     *
     * @param tunnelProgressDetailVo
     * @param neweasetFaceProgress
     * @param neweasetBottomAccumulationLengthProgress
     * @param sortedBigdecimal
     * @param sortedBottomAccumulationLengthBigdecimal
     */
    private void getNeweastProgress(TunnelProgressDetailVo tunnelProgressDetailVo,
                                    BigDecimal neweasetFaceProgress,
                                    BigDecimal neweasetBottomAccumulationLengthProgress,
                                    List<BigDecimal> sortedBigdecimal,
                                    List<BigDecimal> sortedBottomAccumulationLengthBigdecimal) {
        if (DirConstants.CODE_TUNNEL_DIR_IN.equalsIgnoreCase(getSysParamCode(tunnelProgressDetailVo.getTunnelDirId()))) {
            if (!CollectionUtils.isEmpty(sortedBigdecimal)) {
                neweasetFaceProgress.add(sortedBigdecimal.get(sortedBigdecimal.size() - 1));

            }
            if (!CollectionUtils.isEmpty(sortedBottomAccumulationLengthBigdecimal)) {
                neweasetBottomAccumulationLengthProgress.add(sortedBottomAccumulationLengthBigdecimal.get(sortedBottomAccumulationLengthBigdecimal.size() - 1));

            }
        } else if (DirConstants.CODE_TUNNEL_DIR_IN.equalsIgnoreCase(getSysParamCode(tunnelProgressDetailVo.getTunnelDirId()))) {
            if (!CollectionUtils.isEmpty(sortedBigdecimal)) {
                neweasetFaceProgress.add(sortedBigdecimal.get(0));

            }
            if (!CollectionUtils.isEmpty(sortedBottomAccumulationLengthBigdecimal)) {
                neweasetBottomAccumulationLengthProgress.add(sortedBottomAccumulationLengthBigdecimal.get(0));

            }
        }
    }

    @Override
    public List<TunnelSurInfoVo> getTunnelSurInfos(String tunnelId) {
        if (ValidateUtil.paramInvalid(tunnelId)) {
            return null;
        }

        Example ex = new Example(TunnelConsInfoPo.class);
        ex.createCriteria()
                .andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                .andEqualTo("tunnelId", tunnelId);
        List<TunnelConsInfoPo> tunnelConsInfoPos = tunnelConsInfoMapper.selectByExample(ex);

        if (CollectionUtils.isEmpty(tunnelConsInfoPos)) {
            return null;
        }

        return null;
    }

    private Comparator<BigDecimal> getBigDecimalComparator() {
        return (o1, o2) -> {
            if (o1 == o2) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return 1;
            }

            return o1.subtract(o2).intValue();
        };
    }

    @Override
    public BigDecimal getNeweastLinear(String linearId, String tunnelDirId) {

        if (ValidateUtil.paramInvalid(linearId) || ValidateUtil.paramInvalid(tunnelDirId)) {
            return null;
        }

        List<TunnelProgLinerPo> neweastTunnelProgLinerPos = tunnelProgLinerMapper.select(TunnelProgLinerPo.builder()
                .deleteStatus(DeleteStatus.YES.ordinal())
                .prgRecordId(linearId)
                .build());

        if (CollectionUtils.isEmpty(neweastTunnelProgLinerPos)) {
            return null;
        }
        List<BigDecimal> sortedBigdecimal = neweastTunnelProgLinerPos.parallelStream()
                .flatMap((Function<TunnelProgLinerPo, Stream<BigDecimal>>) tunnelProgLinerPo -> {
                    if (tunnelProgLinerPo.getFacePegNoStart() != null && tunnelProgLinerPo.getFacePegNoEnd() != null) {
                        return Stream.of(tunnelProgLinerPo.getFacePegNoStart(), tunnelProgLinerPo.getFacePegNoEnd());
                    }
                    if (tunnelProgLinerPo.getFacePegNoStart() != null && tunnelProgLinerPo.getFacePegNoEnd() == null) {
                        return Stream.of(tunnelProgLinerPo.getFacePegNoStart());
                    }
                    if (tunnelProgLinerPo.getFacePegNoStart() == null && tunnelProgLinerPo.getFacePegNoEnd() != null) {
                        return Stream.of(tunnelProgLinerPo.getFacePegNoEnd());
                    }
                    return Stream.empty();

                })
                .filter(bigDecimal -> bigDecimal != null)
                .sorted(getBigDecimalComparator())
                .collect(Collectors.toList());
        if (DirConstants.CODE_TUNNEL_DIR_IN.equalsIgnoreCase(getSysParamCode(tunnelDirId))) {
            return CollectionUtils.isEmpty(sortedBigdecimal) ? null : sortedBigdecimal.get(sortedBigdecimal.size() - 1);
        } else if (DirConstants.CODE_TUNNEL_DIR_IN.equalsIgnoreCase(getSysParamCode(tunnelDirId))) {
            return CollectionUtils.isEmpty(sortedBigdecimal) ? null : sortedBigdecimal.get(0);
        }

        return null;
    }
}
