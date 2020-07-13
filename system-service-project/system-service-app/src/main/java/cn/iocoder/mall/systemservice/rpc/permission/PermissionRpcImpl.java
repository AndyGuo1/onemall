package cn.iocoder.mall.systemservice.rpc.permission;

import cn.iocoder.common.framework.vo.CommonResult;
import cn.iocoder.mall.systemservice.manager.permission.PermissionManager;
import cn.iocoder.mall.systemservice.rpc.permission.dto.PermissionAssignAdminRoleDTO;
import cn.iocoder.mall.systemservice.rpc.permission.dto.PermissionAssignRoleResourceDTO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static cn.iocoder.common.framework.vo.CommonResult.success;

/**
 * 权限 Rpc 实现类
 */
@Service(version = "${dubbo.provider.PermissionRpc.version}", validation = "false")
public class PermissionRpcImpl implements PermissionRpc {

    @Autowired
    private PermissionManager permissionManager;

    @Override
    public CommonResult<Set<Integer>> listRoleResourceIds(Integer roleId) {
        return success(permissionManager.listRoleResourceIds(roleId));
    }

    @Override
    public CommonResult<Boolean> assignRoleResource(PermissionAssignRoleResourceDTO assignRoleResourceDTO) {
        permissionManager.assignRoleResource(assignRoleResourceDTO);
        return success(true);
    }

    @Override
    public CommonResult<Set<Integer>> listAdminRoleIds(Integer adminId) {
        return success(permissionManager.listAdminRoleIds(adminId));
    }

    @Override
    public CommonResult<Boolean> assignAdminRole(PermissionAssignAdminRoleDTO assignAdminRoleDTO) {
        permissionManager.assignAdminRole(assignAdminRoleDTO);
        return success(true);
    }

}