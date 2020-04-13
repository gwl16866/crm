package com.hy.crmsystem.controller.statistics;


import com.hy.crmsystem.service.statistics.IReturnmoneydetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private IReturnmoneydetailsService returnmoneydetailsService;

    /**
     *
     * @param type
     * @return
     */
    @ResponseBody
    @RequestMapping("/sumWeek.do")
    public String sumWeek(String type){
        BigDecimal m = returnmoneydetailsService.sumWeek(type);
        BigDecimal m_w=null;
        if(m != null){
            m_w= m.divide(new BigDecimal(10000));
            DecimalFormat f = new DecimalFormat("0.00");
            f.setRoundingMode(RoundingMode.HALF_UP);
            return f.format(m_w);
        }else{
            return "";
        }
    }

    @ResponseBody
    @RequestMapping("/sumMonth.do")
    public String sumMonth(String type){
        BigDecimal m = returnmoneydetailsService.sumMonth(type);
        BigDecimal m_w=null;
        if(m != null){
            m_w= m.divide(new BigDecimal(10000));
            DecimalFormat f = new DecimalFormat("0.00");
            f.setRoundingMode(RoundingMode.HALF_UP);
            return f.format(m_w);
        }else{
            return "";
        }
    }

    @ResponseBody
    @RequestMapping("/sumQuarter.do")
    public String sumQuarter(String type){
        BigDecimal m = returnmoneydetailsService.sumQuarter(type);
        BigDecimal m_w=null;
        if(m != null){
            m_w= m.divide(new BigDecimal(10000));
            DecimalFormat f = new DecimalFormat("0.00");
            f.setRoundingMode(RoundingMode.HALF_UP);
            return f.format(m_w);
        }else{
            return "";
        }
    }

    @ResponseBody
    @RequestMapping("/sumYear.do")
    public String sumYear(String type){
        BigDecimal m = returnmoneydetailsService.sumYear(type);
        BigDecimal m_w=null;
        if(m != null){
            m_w= m.divide(new BigDecimal(10000));
            DecimalFormat f = new DecimalFormat("0.00");
            f.setRoundingMode(RoundingMode.HALF_UP);
            return f.format(m_w);
        }else{
            return "";
        }
    }



}
