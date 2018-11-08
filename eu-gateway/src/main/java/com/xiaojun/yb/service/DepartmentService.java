//package com.xiaojun.yb.service;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import yb.ecp.fast.infra.util.ListUtil;
//import yb.ecp.fast.infra.util.Ref;
//import yb.ecp.fast.infra.util.StringUtil;
//import yb.ecp.fast.user.dao.entity.DepartmentDO;
//import yb.ecp.fast.user.dao.mapper.DepartmentMapper;
//import yb.ecp.fast.user.dao.mapper.ProfileMapper;
//import yb.ecp.fast.user.dao.mapper.RoleMapper;
//import yb.ecp.fast.user.infra.ErrorCode;
//import yb.ecp.fast.user.manager.UserContextManager;
//import yb.ecp.fast.user.service.VO.DepartmentVO;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//@Service
//public class DepartmentService {
//
//    @Autowired
//    private UserContextManager userContextManager;
//    @Autowired
//    ProfileService profileService;
//    @Autowired
//    private RoleMapper roleMapper;
//    @Autowired
//    ProfileMapper profileMapper;
//    @Autowired
//    private DepartmentMapper departmentMapper;
//
//
//    // $FF: synthetic method
//    private ErrorCode H(DepartmentDO a1) {
//        if ("0".equals(a1.getParentId())) {
//            return ErrorCode.Success;
//        } else {
//            if (ListUtil.isNullOrEmpty(this.departmentMapper.queryList(a1.getParentId(), (String) null))) {
//                DepartmentDO var2 = new DepartmentDO();
//                var2.setId(a1.getParentId());
//                var2.setLeaf(Integer.valueOf(1));
//                this.departmentMapper.update(var2);
//            }
//
//            return ErrorCode.Success;
//        }
//    }
//
//
//    public DepartmentVO item(String a1) {
//        DepartmentDO a2;
//        if ((a2 = this.departmentMapper.selectById(a1)) == null) {
//            return null;
//        } else {
//            DepartmentVO var2 = new DepartmentVO();
//            BeanUtils.copyProperties(a2, var2);
//            return var2;
//        }
//    }
//
//    public ErrorCode removeByCode(String a1, String a2, Ref a3) {
//        DepartmentDO var4 = this.departmentMapper.selectById(a1);
//        if (null == var4) {
//            return ErrorCode.Success;
//        } else if (this.departmentMapper(a1, a2)) {
//            ArrayList a5;
//            (a5 = new ArrayList()).add(var4.getName());
//            a3.set(a5);
//
//            return ErrorCode.FailedToRemoveRecord;
//        } else {
//            List a4;
//            if (!ListUtil.isNullOrEmpty(a4 = this.beforeRemove(var4.getCode(), a2))) {
//                a3.set(a4);
//
//                return ErrorCode.FailedToRemoveRecord;
//            } else {
//                this.departmentMapper.removeByCode(var4);
//                return this.H(var4);
//            }
//        }
//    }
//
//    // $FF: synthetic method
//    private ErrorCode departmentMapper(DepartmentDO a1) {
//        if ("0".equals(a1.getParentId())) {
//
//            return ErrorCode.Success;
//        } else {
//            if (this.departmentMapper.selectById(a1.getParentId()).getLeaf().intValue() == 1) {
//                DepartmentDO var2 = new DepartmentDO();
//                var2.setId(a1.getParentId());
//                var2.setLeaf(Integer.valueOf(0));
//                int a2 = this.departmentMapper.update(var2);
//                if (0 >= a2) {
//                    return ErrorCode.FailedToUpdateRecord;
//                }
//            }
//
//            return ErrorCode.Success;
//        }
//    }
//
//    public List listDept(String a1, String a2) {
//        a2 = this.userContextManager.getWorkspaceId(a2);
//        if (StringUtils.isBlank(a1)) {
//            a1 = "0";
//        }
//
//        ArrayList var3 = new ArrayList();
//        Iterator a3;
//        Iterator var10000 = a3 = this.departmentMapper.queryList(a1, a2).iterator();
//
//        while (var10000.hasNext()) {
//            DepartmentDO a4 = (DepartmentDO) a3.next();
//            DepartmentVO var4 = new DepartmentVO();
//            var10000 = a3;
//            BeanUtils.copyProperties(a4, var4);
//            var3.add(var4);
//        }
//
//        return var3;
//    }
//
//    public ErrorCode insert(DepartmentVO a1, String workspaceId) {
//        DepartmentDO var3 = new DepartmentDO();
//        BeanUtils.copyProperties(a1, var3);
//        var3.setSpaceId(workspaceId);
//        if (StringUtil.isNullOrEmpty(var3.getParentId())) {
//            var3.setParentId("0");
//        }
//
//        int a3 = this.departmentMapper.checkName(var3);
//        if (0 < a3) {
//            return ErrorCode.DeptNameExist;
//        } else {
//            String a4;
//            if (StringUtil.isNullOrEmpty(a4 = this.createDeptCode(var3.getParentId(), var3.getSpaceId()))) {
//
//                return ErrorCode.FailedToNewCode;
//            } else {
//                var3.setCode(a4);
//                var3.setLeaf(Integer.valueOf(1));
//                a3 = this.departmentMapper.insert(var3);
//                if (0 >= a3) {
//
//                    return ErrorCode.FailedToInsertRecord;
//                } else {
//                    return this.departmentMapper(var3);
//                }
//            }
//        }
//    }
//
//    public List queryDeptList(DepartmentVO a1) {
//        DepartmentDO var2 = new DepartmentDO();
//        ArrayList var3 = new ArrayList();
//        BeanUtils.copyProperties(a1, var2);
//        Iterator a2;
//        Iterator var10000 = a2 = this.departmentMapper.queryDeptList(var2).iterator();
//
//        while (var10000.hasNext()) {
//            var2 = (DepartmentDO) a2.next();
//            DepartmentVO var4 = new DepartmentVO();
//            var10000 = a2;
//            BeanUtils.copyProperties(var2, var4);
//            var3.add(var4);
//        }
//
//        return var3;
//    }
//
//    // $FF: synthetic method
//    private boolean departmentMapper(String a1, String a2) {
//        return this.roleMapper.selectRolesReferencedCount(a1, a2) > 0;
//    }
//
//    public String createDeptCode(String parentId, String spaceId) {
//        DepartmentDO var3 = this.departmentMapper.selectById(parentId);
//        if (StringUtil.isNullOrEmpty(spaceId = this.departmentMapper.queryLastCode(parentId, spaceId))) {
//            //????????????????
//            return "0".equals(parentId) ? "0" : "";
////            return "0".equals(a1) ? ScriptLoader.departmentMapper("R<S") : (new StringBuilder()).insert(0, var3.getCode()).append(ScriptLoader.departmentMapper("R<S")).toString();
//        } else {
//            String code = spaceId;
//            int codeLength = code.length();
//            spaceId = code.substring(0, codeLength - 3);
//            parentId = code.substring(codeLength - 3);
//            if ("".equals(parentId)) {
//                return "";
//            } else {
//                code = parentId;
//                parentId = String.valueOf(Integer.valueOf(parentId).intValue() + 1);
//                int var5;
//                if ((var5 = code.length() - parentId.length()) > 0) {
//                    for (int var6 = var5; var6 > 0; var6 = var5) {
//                        StringBuilder var7 = (new StringBuilder()).insert(0, "0");
//                        --var5;
//                        parentId = var7.append(parentId).toString();
//                    }
//                }
//
//                return (new StringBuilder()).insert(0, spaceId).append(parentId).toString();
//            }
//        }
//    }
//
//    public ErrorCode update(DepartmentVO a1) {
//        DepartmentDO var2 = this.departmentMapper.selectById(a1.getId());
//        if (null == var2) {
//
//            return ErrorCode.FailedToUpdateRecord;
//        } else if (var2.getName().equals(a1.getName())) {
//
//            return ErrorCode.Success;
//        } else {
//            var2.setName(a1.getName());
//            var2.setSeq(a1.getSeq());
//            int a2 = this.departmentMapper.checkName(var2);
//            if (0 < a2) {
//                return ErrorCode.DeptNameExist;
//            } else {
//                a2 = this.departmentMapper.update(var2);
//                if (0 >= a2) {
//                    return ErrorCode.FailedToUpdateRecord;
//                } else {
//                    return ErrorCode.Success;
//                }
//            }
//        }
//    }
//
//    public List beforeRemove(String a1, String a2) {
//        DepartmentDO var3 = new DepartmentDO();
//        var3.setCode(a1);
//        var3.setSpaceId(a2);
//        ArrayList a3 = new ArrayList();
//        List a4;
//        if (ListUtil.isNullOrEmpty(a4 = this.departmentMapper.selectDeptNotEmpty(var3))) {
//            return new ArrayList();
//        } else {
//            Iterator a5;
//            Iterator var10000 = a5 = a4.iterator();
//
//            while (var10000.hasNext()) {
//                var3 = (DepartmentDO) a5.next();
//                if (null == var3) {
//                    var10000 = a5;
//                } else {
//                    a3.add(var3.getName());
//                    var10000 = a5;
//                }
//            }
//
//            return a3;
//        }
//    }
//
//    public String queryFullDeptName(String deptId) {
//        if ("0".equals(deptId)) {
//            return "";
//        } else {
//            StringBuffer var2 = new StringBuffer();
//            StringBuffer var4 = null;
//            //TODO 最深10层
//            int deep = 0;
//            while (true && deep < 10) {
//                deep++;
//                DepartmentVO departmentVO = this.item(deptId);
//                if (null == departmentVO) {
//                    return "";
//                }
//
//                var2.insert(0, departmentVO.getName());
//                if ("0".equals(departmentVO.getParentId())) {
//                    var4 = var2;
//                    break;
//                }
//
//                if ("".equals(departmentVO.getParentId())) {
//                    var4 = var2;
//                    break;
//                }
//                //???????????????????????
//                deptId = departmentVO.getParentId();
//            }
//            return var4.toString();
//        }
//    }
//}
