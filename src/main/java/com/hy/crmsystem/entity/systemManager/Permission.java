package com.hy.crmsystem.entity.systemManager;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Ȩ
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;

    @TableField("permission_name")
    private String permissionName;

    @TableField("parent_id")
    private Integer parentId;

    private String url;

    private List<Permission> menuPermission;

    public List<Permission> getMenuPermission() {
        return menuPermission;
    }

    public void setMenuPermission(List<Permission> menuPermission) {
        this.menuPermission = menuPermission;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "pid=" + pid +
                ", permissionName='" + permissionName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
