package com.gxuwz.attend.entity;

public class department {
    private String depId;
    private String depName;
    private String depaType;

    public department(String depId, String depName, String depaType) {
        this.depId = depId;
        this.depName = depName;
        this.depaType = depaType;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepaType() {
        return depaType;
    }

    public void setDepaType(String depaType) {
        this.depaType = depaType;
    }

    @Override
    public String toString() {
        return "department{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                ", depaType='" + depaType + '\'' +
                '}';
    }
}
