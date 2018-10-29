package com.cmct.base.constant;


import java.util.Arrays;

/**
 * 目前是4个模块
 *
 * @author shen
 * @version 1.0.0
 * @since 2018/3/27
 */
public enum Module {

    BRIDGE("module_bridge", "桥梁模块", 0),
    SLOPE("module_slope", "边坡模块", 1),
    PAVE("module_pave", "路面模块", 2);

    /**
     *
     */
    private String moduleCode;

    /**
     *
     */
    private String moduleName;
    /**
     *
     */
    private int moduletType;

    Module(String moduleCode,
           String moduleName,
           int moduletType) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.moduletType = moduletType;
    }


    public static Module getModule(Integer moduleType) throws Exception {

        return Arrays.stream(Module.values())
                .filter(module -> module.getModuletType() == moduleType)
                .findFirst()
                .orElseThrow(() -> new Exception("没有找到该Module"));
    }

    public int getModuletType() {
        return moduletType;
    }

    public void setModuletType(int moduletType) {
        this.moduletType = moduletType;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleCode='" + moduleCode + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", moduletType=" + moduletType +
                '}';
    }
}
