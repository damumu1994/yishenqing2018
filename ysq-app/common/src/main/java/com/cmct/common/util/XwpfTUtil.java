package com.cmct.common.util;

import org.apache.poi.xwpf.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * word
 *
 * @author shen
 * @version v2.0
 * @since 2018/3/14
 */
public class XwpfTUtil {

    private static final Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);

    /**
     * 替换所有段落里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    public static void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            replaceInPara(para, params);
        }
    }

    /**
     * 替换段落里面的变量
     *
     * @param para   要替换的段落
     * @param params 参数
     */
    public static void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        List<XWPFRun> runs;
        if (matcher(para.getParagraphText()).find()) {
            runs = para.getRuns();
            int start = -1;
            int end = -1;
            String str = "";
            for (int i = 0; i < runs.size(); i++) {
                XWPFRun run = runs.get(i);
                String runText = run.toString();
                if ('$' == runText.charAt(0) && '{' == runText.charAt(1)) {
                    start = i;
                }
                if ((start != -1)) {
                    str += runText;
                }
                if ('}' == runText.charAt(runText.length() - 1)) {
                    if (start != -1) {
                        end = i;
                        break;
                    }
                }
            }

            for (int i = start; i <= end; i++) {
                para.removeRun(i);
                i--;
                end--;
            }

            for (String key : params.keySet()) {
                if (str.equals(key)) {
                    para.createRun().setText((String) params.get(key));
                    break;
                }
            }


        }
    }

    /**
     * 替换表格里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    public static void replaceInTable(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
            for (XWPFTableRow row : rows) {
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        replaceInPara(para, params);
                    }
                }
            }
        }
    }

    /**
     * 正则匹配字符串
     *
     * @param str
     * @return
     */
    private static Matcher matcher(String str) {
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }

    /**
     * 关闭输入流
     *
     * @param is
     */
    public static void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     *
     * @param os
     */
    public static void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 匹配获取wordStr中的替换标志
     *
     * @param wordStr
     * @return
     */
    public static List<String> getReplaceFlag(String wordStr) {

        String rge = "\\$\\{(.*?)}";
        List<String> list = new ArrayList<>(10);
        Pattern pattern;
        Matcher m;
        pattern = Pattern.compile(rge);
        m = pattern.matcher(wordStr);
        while (m.find()) {
            list.add(m.group(1));
        }


        return list;
    }


    /**
     * 匹配获取wordStr中的替换标志
     *
     * @param wordStr
     * @return
     */
    public static List<ReplaceFlagAndPosition> getReplaceFlagWithPosition(String wordStr) {

        String rgex = "\\$\\{(.*?)}";
        List<ReplaceFlagAndPosition> list = new ArrayList<>(10);
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(wordStr);

        while (m.find()) {
            list.add(ReplaceFlagAndPosition.builder().regResult(m.group(1)).position(m.start()).build());
        }

        return list;
    }

}
