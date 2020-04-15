package com.hy.crmsystem.service.statistics.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.statistics.AllWeekStatistics;
import com.hy.crmsystem.entity.statistics.Returnmoneydetails;
import com.hy.crmsystem.entity.statistics.TableStatistics;
import com.hy.crmsystem.mapper.statistics.ReturnmoneydetailsMapper;
import com.hy.crmsystem.service.statistics.IReturnmoneydetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Service
@Transactional
public class ReturnmoneydetailsServiceImpl extends ServiceImpl<ReturnmoneydetailsMapper, Returnmoneydetails> implements IReturnmoneydetailsService {

    @Autowired
    private ReturnmoneydetailsMapper returnmoneydetailsMapper;
    @Override
    public BigDecimal sumWeek(String type) {
        return returnmoneydetailsMapper.sumWeek(type);
    }

    @Override
    public BigDecimal sumMonth(String type) {
        return returnmoneydetailsMapper.sumMonth(type);
    }

    @Override
    public BigDecimal sumQuarter(String type) {
        return returnmoneydetailsMapper.sumQuarter(type);
    }

    @Override
    public BigDecimal sumYear(String type) {
        return returnmoneydetailsMapper.sumYear(type);
    }

    @Override
    public BigDecimal sumDocumentary(String type) {
        return returnmoneydetailsMapper.sumDocumentary(type);
    }

    @Override
    public BigDecimal sumContract(String type) {
        return returnmoneydetailsMapper.sumContract(type);
    }

    @Override
    public BigDecimal sumOkMoney(String type) {
        return returnmoneydetailsMapper.sumOkMoney(type);
    }

    @Override
    public List<AllWeekStatistics> sumAll(String type) {

        List<AllWeekStatistics> all = new ArrayList<>();

        List<Customer> customerList = returnmoneydetailsMapper.selectCustomer();

        for(int i=0;i<customerList.size();i++){
            if(customerList.get(i).getCid() != 0){

                if(type.equals("week")){
                    AllWeekStatistics a = new AllWeekStatistics();
                    a.setName(customerList.get(i).getCname());
                    //查询商机本周
                    TableStatistics sjbz = returnmoneydetailsMapper.sumWeekAndCustomer("bz",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumWeekAndCustomerCounts("bz",customerList.get(i).getCname())>0){

                        a.setSj_bz_money(decimalFormatString(sjbz.getMoney()));
                    }else {
                        a.setSj_bz_money("0");
                    }
                    //查询商机上周
                    TableStatistics sjsz = returnmoneydetailsMapper.sumWeekAndCustomer("sz",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumWeekAndCustomerCounts("sz",customerList.get(i).getCname())>0) {
                        a.setSj_sz_money(decimalFormatString(sjsz.getMoney()));
                    }else {
                        a.setSj_sz_money("0");
                    }

                    //查询成交本周
                    TableStatistics cjbz = returnmoneydetailsMapper.sumOkMoneyAndCustomer("cjbz",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumOkMoneyAndCustomerCounts("cjbz",customerList.get(i).getCname())>0) {
                        a.setCj_bz_money(decimalFormatString(cjbz.getMoney()));
                    }else {
                        a.setCj_bz_money("0");
                    }

                    //查询成交上周
                    TableStatistics cjsz = returnmoneydetailsMapper.sumOkMoneyAndCustomer("cjsz",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumOkMoneyAndCustomerCounts("cjsz",customerList.get(i).getCname())>0) {
                        a.setCj_sz_money(decimalFormatString(cjsz.getMoney()));
                    }else {
                        a.setCj_sz_money("0");
                    }


                    //查询跟单本周
                    TableStatistics gdbz = returnmoneydetailsMapper.sumDocumentaryAndCustomer("gdbz",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumDocumentaryAndCustomerCounts("gdbz",customerList.get(i).getCname())>0) {
                        a.setGd_bz_money(decimalFormatString(gdbz.getMoney()));
                    }else {
                        a.setGd_bz_money("0");
                    }

                    //查询跟单上周
                    TableStatistics gdsz = returnmoneydetailsMapper.sumDocumentaryAndCustomer("gdsz",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumDocumentaryAndCustomerCounts("gdsz",customerList.get(i).getCname())>0) {
                        a.setGd_sz_money(decimalFormatString(gdsz.getMoney()));
                    }else {
                        a.setGd_sz_money("0");
                    }

                    //查询合同本周
                    TableStatistics htbz = returnmoneydetailsMapper.sumContractAndCustomer("htbz",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumContractAndCustomerCounts("htbz",customerList.get(i).getCname())>0) {
                        a.setHt_bz_money(decimalFormatString(htbz.getMoney()));
                    }else {
                        a.setHt_bz_money("0");
                    }
                    //查询合同上周
                    TableStatistics htsz = returnmoneydetailsMapper.sumContractAndCustomer("htsz",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumContractAndCustomerCounts("htsz",customerList.get(i).getCname())>0) {
                        a.setHt_sz_money(decimalFormatString(htsz.getMoney()));
                    }else {
                        a.setHt_sz_money("0");
                    }

                    all.add(a);
                }


                if(type.equals("month")){
                    AllWeekStatistics a = new AllWeekStatistics();
                    a.setName(customerList.get(i).getCname());
                    //查询商机本月
                    TableStatistics sjby = returnmoneydetailsMapper.sumMonthAndCustomer("by",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumMonthAndCustomerCounts("by",customerList.get(i).getCname())>0){
                        a.setSj_by_money(decimalFormatString(sjby.getMoney()));
                    }else {
                        a.setSj_by_money("0");
                    }
                    //查询商机上月
                    TableStatistics sjsy = returnmoneydetailsMapper.sumMonthAndCustomer("sz",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumMonthAndCustomerCounts("sy",customerList.get(i).getCname())>0) {
                        a.setSj_sy_money(decimalFormatString(sjsy.getMoney()));
                    }else {
                        a.setSj_sy_money("0");
                    }

                    //查询成交本月
                    TableStatistics cjby = returnmoneydetailsMapper.sumOkMoneyAndCustomer("cjby",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumOkMoneyAndCustomerCounts("cjby",customerList.get(i).getCname())>0) {
                        a.setCj_by_money(decimalFormatString(cjby.getMoney()));
                    }else {
                        a.setCj_by_money("0");
                    }

                    //查询成交上月
                    TableStatistics cjsy = returnmoneydetailsMapper.sumOkMoneyAndCustomer("cjsy",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumOkMoneyAndCustomerCounts("cjsy",customerList.get(i).getCname())>0) {
                        a.setCj_sy_money(decimalFormatString(cjsy.getMoney()));
                    }else {
                        a.setCj_sy_money("0");
                    }


                    //查询跟单本月
                    TableStatistics gdby = returnmoneydetailsMapper.sumDocumentaryAndCustomer("gdby",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumDocumentaryAndCustomerCounts("gdby",customerList.get(i).getCname())>0) {
                        a.setGd_by_money(decimalFormatString(gdby.getMoney()));
                    }else {
                        a.setGd_by_money("0");
                    }

                    //查询跟单上月
                    TableStatistics gdsy = returnmoneydetailsMapper.sumDocumentaryAndCustomer("gdsy",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumDocumentaryAndCustomerCounts("gdsy",customerList.get(i).getCname())>0) {
                        a.setGd_sy_money(decimalFormatString(gdsy.getMoney()));
                    }else {
                        a.setGd_sy_money("0");
                    }

                    //查询合同本月
                    TableStatistics htby = returnmoneydetailsMapper.sumContractAndCustomer("htby",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumContractAndCustomerCounts("htby",customerList.get(i).getCname())>0) {
                        a.setHt_by_money(decimalFormatString(htby.getMoney()));
                    }else {
                        a.setHt_by_money("0");
                    }
                    //查询合同上月
                    TableStatistics htsy = returnmoneydetailsMapper.sumContractAndCustomer("htsy",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumContractAndCustomerCounts("htsy",customerList.get(i).getCname())>0) {
                        a.setHt_sy_money(decimalFormatString(htsy.getMoney()));
                    }else {
                        a.setHt_sy_money("0");
                    }
                    all.add(a);


                }

                if(type.equals("quarter")){
                    AllWeekStatistics a = new AllWeekStatistics();
                    a.setName(customerList.get(i).getCname());
                    //查询商机本季
                    TableStatistics sjbj = returnmoneydetailsMapper.sumQuarterAndCustomer("bj",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumQuarterAndCustomerCounts("bj",customerList.get(i).getCname())>0){
                        a.setSj_bj_money(decimalFormatString(sjbj.getMoney()));
                    }else {
                        a.setSj_bj_money("0");
                    }
                    //查询商机上季
                    TableStatistics sjsj = returnmoneydetailsMapper.sumQuarterAndCustomer("sj",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumQuarterAndCustomerCounts("sj",customerList.get(i).getCname())>0) {
                        a.setSj_sj_money(decimalFormatString(sjsj.getMoney()));
                    }else {
                        a.setSj_sj_money("0");
                    }

                    //查询成交本季
                    TableStatistics cjbj = returnmoneydetailsMapper.sumOkMoneyAndCustomer("cjbj",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumOkMoneyAndCustomerCounts("cjbj",customerList.get(i).getCname())>0) {
                        a.setCj_bj_money(decimalFormatString(cjbj.getMoney()));
                    }else {
                        a.setCj_bj_money("0");
                    }

                    //查询成交上季
                    TableStatistics cjsj = returnmoneydetailsMapper.sumOkMoneyAndCustomer("cjsj",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumOkMoneyAndCustomerCounts("cjsj",customerList.get(i).getCname())>0) {
                        a.setCj_sj_money(decimalFormatString(cjsj.getMoney()));
                    }else {
                        a.setCj_sj_money("0");
                    }


                    //查询跟单本季
                    TableStatistics gdbj = returnmoneydetailsMapper.sumDocumentaryAndCustomer("gdbj",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumDocumentaryAndCustomerCounts("gdbj",customerList.get(i).getCname())>0) {
                        a.setGd_bj_money(decimalFormatString(gdbj.getMoney()));
                    }else {
                        a.setGd_bj_money("0");
                    }

                    //查询跟单上季
                    TableStatistics gdsj = returnmoneydetailsMapper.sumDocumentaryAndCustomer("gdsj",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumDocumentaryAndCustomerCounts("gdsj",customerList.get(i).getCname())>0) {
                        a.setGd_sj_money(decimalFormatString(gdsj.getMoney()));
                    }else {
                        a.setGd_sj_money("0");
                    }

                    //查询合同本季
                    TableStatistics htbj = returnmoneydetailsMapper.sumContractAndCustomer("htbj",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumContractAndCustomerCounts("htbj",customerList.get(i).getCname())>0) {
                        a.setHt_bj_money(decimalFormatString(htbj.getMoney()));
                    }else {
                        a.setHt_bj_money("0");
                    }
                    //查询合同上季
                    TableStatistics htsj = returnmoneydetailsMapper.sumContractAndCustomer("htsj",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumContractAndCustomerCounts("htsj",customerList.get(i).getCname())>0) {
                        a.setHt_sj_money(decimalFormatString(htsj.getMoney()));
                    }else {
                        a.setHt_sj_money("0");
                    }
                    all.add(a);


                }


                if(type.equals("year")){
                    AllWeekStatistics a = new AllWeekStatistics();
                    a.setName(customerList.get(i).getCname());
                    //查询商机本年
                    TableStatistics sjbn = returnmoneydetailsMapper.sumYearAndCustomer("bn",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumYearAndCustomerCounts("bn",customerList.get(i).getCname())>0){
                        a.setSj_bn_money(decimalFormatString(sjbn.getMoney()));
                    }else {
                        a.setSj_bn_money("0");
                    }
                    //查询商机上年
                    TableStatistics sjsn = returnmoneydetailsMapper.sumYearAndCustomer("sn",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumYearAndCustomerCounts("sn",customerList.get(i).getCname())>0) {
                        a.setSj_sn_money(decimalFormatString(sjsn.getMoney()));
                    }else {
                        a.setSj_sn_money("0");
                    }

                    //查询成交本年
                    TableStatistics cjbn = returnmoneydetailsMapper.sumOkMoneyAndCustomer("cjbn",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumOkMoneyAndCustomerCounts("cjbn",customerList.get(i).getCname())>0) {
                        a.setCj_bn_money(decimalFormatString(cjbn.getMoney()));
                    }else {
                        a.setCj_bn_money("0");
                    }

                    //查询成交上年
                    TableStatistics cjsn = returnmoneydetailsMapper.sumOkMoneyAndCustomer("cjsn",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumOkMoneyAndCustomerCounts("cjsn",customerList.get(i).getCname())>0) {
                        a.setCj_sn_money(decimalFormatString(cjsn.getMoney()));
                    }else {
                        a.setCj_sn_money("0");
                    }


                    //查询跟单本年
                    TableStatistics gdbn = returnmoneydetailsMapper.sumDocumentaryAndCustomer("gdbn",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumDocumentaryAndCustomerCounts("gdbn",customerList.get(i).getCname())>0) {
                        a.setGd_bn_money(decimalFormatString(gdbn.getMoney()));
                    }else {
                        a.setGd_bn_money("0");
                    }

                    //查询跟单上年
                    TableStatistics gdsn = returnmoneydetailsMapper.sumDocumentaryAndCustomer("gdsn",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumDocumentaryAndCustomerCounts("gdsn",customerList.get(i).getCname())>0) {
                        a.setGd_sn_money(decimalFormatString(gdsn.getMoney()));
                    }else {
                        a.setGd_sn_money("0");
                    }

                    //查询合同本年
                    TableStatistics htbn = returnmoneydetailsMapper.sumContractAndCustomer("htbn",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumContractAndCustomerCounts("htbn",customerList.get(i).getCname())>0) {
                        a.setHt_bn_money(decimalFormatString(htbn.getMoney()));
                    }else {
                        a.setHt_bn_money("0");
                    }
                    //查询合同上年
                    TableStatistics htsn = returnmoneydetailsMapper.sumContractAndCustomer("htsn",customerList.get(i).getCname());
                    if(returnmoneydetailsMapper.sumContractAndCustomerCounts("htsn",customerList.get(i).getCname())>0) {
                        a.setHt_sn_money(decimalFormatString(htsn.getMoney()));
                    }else {
                        a.setHt_sn_money("0");
                    }
                    all.add(a);


                }


            }
        }

        return all;
    }

    @Override
    public String decimalFormatString(BigDecimal decimalParam) {
        BigDecimal m_w= decimalParam.divide(new BigDecimal(10000));
        DecimalFormat f = new DecimalFormat("0.00");
        f.setRoundingMode(RoundingMode.HALF_UP);
        return f.format(m_w);
    }

}
