package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_depart_link")
public class TunnelDepartLinkPo {

  private String otherId;
  private String tunnelProId;
  private String construction;
  private String consts;
  private String constBlocks;
  private String supervision;
  private String supervisionBlocks;
  private String monitor;
  private String monitorBlocks;
  private String designDep;
  private String otherDep;


  public String getOtherId() {
    return otherId;
  }

  public void setOtherId(String otherId) {
    this.otherId = otherId;
  }


  public String getTunnelProId() {
    return tunnelProId;
  }

  public void setTunnelProId(String tunnelProId) {
    this.tunnelProId = tunnelProId;
  }


  public String getConstruction() {
    return construction;
  }

  public void setConstruction(String construction) {
    this.construction = construction;
  }


  public String getConsts() {
    return consts;
  }

  public void setConsts(String consts) {
    this.consts = consts;
  }


  public String getConstBlocks() {
    return constBlocks;
  }

  public void setConstBlocks(String constBlocks) {
    this.constBlocks = constBlocks;
  }


  public String getSupervision() {
    return supervision;
  }

  public void setSupervision(String supervision) {
    this.supervision = supervision;
  }


  public String getSupervisionBlocks() {
    return supervisionBlocks;
  }

  public void setSupervisionBlocks(String supervisionBlocks) {
    this.supervisionBlocks = supervisionBlocks;
  }


  public String getMonitor() {
    return monitor;
  }

  public void setMonitor(String monitor) {
    this.monitor = monitor;
  }


  public String getMonitorBlocks() {
    return monitorBlocks;
  }

  public void setMonitorBlocks(String monitorBlocks) {
    this.monitorBlocks = monitorBlocks;
  }


  public String getDesignDep() {
    return designDep;
  }

  public void setDesignDep(String designDep) {
    this.designDep = designDep;
  }


  public String getOtherDep() {
    return otherDep;
  }

  public void setOtherDep(String otherDep) {
    this.otherDep = otherDep;
  }

}
