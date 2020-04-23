package com.hy.crmsystem.service.systemManager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.systemManager.*;
import com.hy.crmsystem.mapper.bussinessOppo.BusinessoppoMapper;
import com.hy.crmsystem.mapper.contract.ContractMapper;
import com.hy.crmsystem.mapper.customerManager.CustomerMapper;
import com.hy.crmsystem.mapper.statistics.ReturnmoneydetailsMapper;
import com.hy.crmsystem.mapper.systemManager.DeptMapper;
import com.hy.crmsystem.mapper.systemManager.LoginMapper;
import com.hy.crmsystem.mapper.systemManager.UserMapper;
import com.hy.crmsystem.service.systemManager.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BusinessoppoMapper businessoppoMapper;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private ReturnmoneydetailsMapper returnmoneydetailsMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private DeptMapper deptMapper;

    public List<UserDept> selectAllUser(UserDept user) {
        return userMapper.selectAllUser(user);
    }
    public User selectUserByUid(Integer uid) {
        return userMapper.selectUserByUid(uid);
    }


    //不修改密码
    public void NoupdateUserPassword(User user) {
        userMapper.NoupdateUserPassword(user);
    }

    //修改用户
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
    public void deleteUser(Integer uid){
        userMapper.deleteUser(uid);
    }


    public User selectDengLuRen(Object name){
        return userMapper.selectDengLuRen(name);
    }
    public String selectname(String username){
        return userMapper.selectname(username);
    }

    public void add(User user){
         userMapper.Add(user);
    }

    public List<Dept> select(){
      return deptMapper.selectdept();
    }

    @Override
    public Integer selectUserCounts() {
        return userMapper.selectCount(null);
    }

    @Override
    public Integer selectBussCounts() {
        return businessoppoMapper.selectCount(null);
    }

    @Override
    public Integer selectContractCounts() {
        return contractMapper.selectCount(null);
    }

    @Override
    public String selectRetrurnMoney() {
        return returnmoneydetailsMapper.selectReturnMoney();
    }

    @Override
    public ArrayList<String> selectMoneyByMonth() {
        DeskMonth dm=new DeskMonth();
        ArrayList<DeskPojo> d = userMapper.seleMoneyByMonth();

        for(int i=0;i<d.size();i++){
            if(d.get(i).getMonth().equals("01")){
                dm.setOne(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("02")){
                dm.setTwo(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("03")){
                dm.setThree(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("04")){
                dm.setFour(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("05")){
                dm.setFive(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("06")){
                dm.setSix(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("07")){
                dm.setSeven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("08")){
                dm.setEight(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("09")){
                dm.setNine(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("10")){
                dm.setTen(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("11")){
                dm.setEleven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("12")){
                dm.setTwelve(d.get(i).getVal());
            }
        }
        ArrayList<String> arr = new ArrayList<>();
            arr.add(0,dm.getOne());
            arr.add(1,dm.getTwo());
            arr.add(2,dm.getThree());
            arr.add(3,dm.getFour());
            arr.add(4,dm.getFive());
            arr.add(5,dm.getSix());
            arr.add(6,dm.getSeven());
            arr.add(7,dm.getEight());
            arr.add(8,dm.getNine());
            arr.add(9,dm.getTen());
            arr.add(10,dm.getEleven());
            arr.add(11,dm.getTwelve());
        return arr;
    }

    @Override
    public ArrayList<String> selectSumUsers() {
        DeskMonth dm=new DeskMonth();
        ArrayList<DeskPojo> d = userMapper.selectSumUsers();

        for(int i=0;i<d.size();i++){
            if(d.get(i).getMonth().equals("01")){
                dm.setOne(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("02")){
                dm.setTwo(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("03")){
                dm.setThree(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("04")){
                dm.setFour(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("05")){
                dm.setFive(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("06")){
                dm.setSix(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("07")){
                dm.setSeven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("08")){
                dm.setEight(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("09")){
                dm.setNine(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("10")){
                dm.setTen(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("11")){
                dm.setEleven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("12")){
                dm.setTwelve(d.get(i).getVal());
            }
        }
        ArrayList<String> arr = new ArrayList<>();
        arr.add(0,dm.getOne());
        arr.add(1,dm.getTwo());
        arr.add(2,dm.getThree());
        arr.add(3,dm.getFour());
        arr.add(4,dm.getFive());
        arr.add(5,dm.getSix());
        arr.add(6,dm.getSeven());
        arr.add(7,dm.getEight());
        arr.add(8,dm.getNine());
        arr.add(9,dm.getTen());
        arr.add(10,dm.getEleven());
        arr.add(11,dm.getTwelve());
        return arr;
    }

    @Override
    public ArrayList<String> selectSumCustomer() {
        DeskMonth dm=new DeskMonth();
        ArrayList<DeskPojo> d = userMapper.selectSumCustomer();

        for(int i=0;i<d.size();i++){
            if(d.get(i).getMonth().equals("01")){
                dm.setOne(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("02")){
                dm.setTwo(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("03")){
                dm.setThree(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("04")){
                dm.setFour(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("05")){
                dm.setFive(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("06")){
                dm.setSix(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("07")){
                dm.setSeven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("08")){
                dm.setEight(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("09")){
                dm.setNine(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("10")){
                dm.setTen(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("11")){
                dm.setEleven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("12")){
                dm.setTwelve(d.get(i).getVal());
            }
        }
        ArrayList<String> arr = new ArrayList<>();
        arr.add(0,dm.getOne());
        arr.add(1,dm.getTwo());
        arr.add(2,dm.getThree());
        arr.add(3,dm.getFour());
        arr.add(4,dm.getFive());
        arr.add(5,dm.getSix());
        arr.add(6,dm.getSeven());
        arr.add(7,dm.getEight());
        arr.add(8,dm.getNine());
        arr.add(9,dm.getTen());
        arr.add(10,dm.getEleven());
        arr.add(11,dm.getTwelve());
        return arr;
    }

    @Override
    public ArrayList<String> selectBussinessCounts() {
        DeskMonth dm=new DeskMonth();
        ArrayList<DeskPojo> d = userMapper.selectBussinessCounts();

        for(int i=0;i<d.size();i++){
            if(d.get(i).getMonth().equals("01")){
                dm.setOne(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("02")){
                dm.setTwo(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("03")){
                dm.setThree(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("04")){
                dm.setFour(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("05")){
                dm.setFive(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("06")){
                dm.setSix(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("07")){
                dm.setSeven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("08")){
                dm.setEight(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("09")){
                dm.setNine(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("10")){
                dm.setTen(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("11")){
                dm.setEleven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("12")){
                dm.setTwelve(d.get(i).getVal());
            }
        }
        ArrayList<String> arr = new ArrayList<>();
        arr.add(0,dm.getOne());
        arr.add(1,dm.getTwo());
        arr.add(2,dm.getThree());
        arr.add(3,dm.getFour());
        arr.add(4,dm.getFive());
        arr.add(5,dm.getSix());
        arr.add(6,dm.getSeven());
        arr.add(7,dm.getEight());
        arr.add(8,dm.getNine());
        arr.add(9,dm.getTen());
        arr.add(10,dm.getEleven());
        arr.add(11,dm.getTwelve());
        return arr;
    }

    @Override
    public ArrayList<String> selectContractCountsByMonth() {
        DeskMonth dm=new DeskMonth();
        ArrayList<DeskPojo> d = userMapper.selectContractCounts();

        for(int i=0;i<d.size();i++){
            if(d.get(i).getMonth().equals("01")){
                dm.setOne(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("02")){
                dm.setTwo(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("03")){
                dm.setThree(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("04")){
                dm.setFour(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("05")){
                dm.setFive(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("06")){
                dm.setSix(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("07")){
                dm.setSeven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("08")){
                dm.setEight(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("09")){
                dm.setNine(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("10")){
                dm.setTen(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("11")){
                dm.setEleven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("12")){
                dm.setTwelve(d.get(i).getVal());
            }
        }
        ArrayList<String> arr = new ArrayList<>();
        arr.add(0,dm.getOne());
        arr.add(1,dm.getTwo());
        arr.add(2,dm.getThree());
        arr.add(3,dm.getFour());
        arr.add(4,dm.getFive());
        arr.add(5,dm.getSix());
        arr.add(6,dm.getSeven());
        arr.add(7,dm.getEight());
        arr.add(8,dm.getNine());
        arr.add(9,dm.getTen());
        arr.add(10,dm.getEleven());
        arr.add(11,dm.getTwelve());
        return arr;
    }

    @Override
    public Integer selectCustomerCounts() {
        return customerMapper.selectCount(null);
    }

    @Override
    public List<Dept> queryDept() {
        return userMapper.queryDept();
    }

    @Override
    public List<Role> queryAllRole(Role role) {
        return userMapper.queryAllRole(role);
    }

    @Override
    public List<Integer> queryHaveRole(Integer uid) {
        return userMapper.queryHaveRole(uid);
    }

    @Override
    public Role queryRoleById(Integer rid) {
        return userMapper.queryRoleById(rid);
    }

    @Override
    public void updateRole(Role role) {
        userMapper.updateRoleById(role);
    }

    @Override
    public void deleteRole(Integer rid) {
        userMapper.deleteRoleById(rid);
    }

    @Override
    public Integer selectCountUserRole(Integer rid) {
        return userMapper.selectCountUserRole(rid);
    }

    @Override
    public Integer selectCountRolePermission(Integer rid) {
        return userMapper.selectCountRolePermission(rid);
    }

    @Override
    public void addRole(String name) {
        userMapper.addRole(name);

    }

    @Override
    public void updateRoleIdByUid(String[] rid, Integer uid) {
        userMapper.updateRoleIdByUid(rid,uid);
    }

    @Override
    public void updateUserHandByUid(String[] pid, Integer uid) {
        userMapper.updateUserHandByUid(pid,uid);
    }

    @Override
    public void updateRoleHandByRid(String[] pid, Integer rid) {
        userMapper.updateRoleHandByRid(pid,rid);

    }

    @Override
    public void deleteUserRoleByUid(Integer uid) {
        userMapper.deleteUserRoleByUid(uid);
    }

    @Override
    public void deleteUserPermissionByUid(Integer uid) {
        userMapper.deleteUserPermissionByUid(uid);

    }

    @Override
    public void deleteRolePermissionByRid(Integer rid) {
        userMapper.deleteRolePermissionByRid(rid);
    }


    @Override
    public List<Permission> queryFirstPermission() {
        return userMapper.queryFirstPermission();
    }

    @Override
    public List<Integer> userHaveHand(Integer uid) {
        return userMapper.userHaveHand(uid);
    }

    @Override
    public List<Integer> roleHaveHand(Integer rid) {
        return userMapper.roleHaveHand(rid);
    }

    @Override
    public List<Permission> secondThirdHand(Integer parentId) {
        return userMapper.secondThirdHand(parentId);
    }

    @Override
    public List<Permission> recursionHands(List<Permission> list){

        if(null != list && !list.isEmpty()){
            for(Permission firstHands:list){
                List<Permission> secondList=secondThirdHand(firstHands.getPid());
                firstHands.setMenuPermission(secondList);
                recursionHands(secondList);
            }
        }
        return list;
    }

    @Override
    public HashSet<String> selectRoleByUid(Integer uid) {
        return userMapper.selectRoleByUid(uid);
    }

    @Override
    public HashSet<String> selectHandNameByUid(Integer uid) {
        return userMapper.selectHandNameByUid(uid);
    }

    @Override
    public HashSet<String> selectRoleHandNameByUid(Integer uid) {
        return userMapper.selectRoleHandNameByName(uid);
    }

    @Override
    public String[] selectThirdPerms(String[] pids) {
        return userMapper.selectThirdPerms(pids);
    }
}
