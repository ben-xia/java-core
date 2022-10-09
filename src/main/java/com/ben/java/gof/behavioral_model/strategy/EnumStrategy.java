package com.ben.java.gof.behavioral_model.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author ben-xia
 * @date 2021/04/23
 * @Description TODO
 **/
public enum EnumStrategy {
    UserDiscountStrategy {

        @Override
        BigDecimal getDiscount(BigDecimal total) {
            // 普通会员打九折:
            return total.multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.DOWN);
        }

    },
    OverDiscountStrategy {

        @Override
        BigDecimal getDiscount(BigDecimal total) {
            // 满100减20优惠:
            return total.compareTo(BigDecimal.valueOf(100)) >= 0 ? total.subtract(new BigDecimal(20)) : total;
        }

    },
    PrimeDiscountStrategy {

        @Override
        BigDecimal getDiscount(BigDecimal total) {
            // Prime会员打七折:
            return total.multiply(new BigDecimal("0.3")).setScale(2, RoundingMode.DOWN);
        }

    },
    OverPrimeDiscountStrategy {

        @Override
        BigDecimal getDiscount(BigDecimal total) {
            // 在满100减20的基础上对Prime会员再打七折:
            BigDecimal count = BigDecimal.valueOf(0);
            count = count.add(OverDiscountStrategy.getDiscount(total));
            count = count.add(PrimeDiscountStrategy.getDiscount(total.subtract(count)));
            return count;
        }

    };

    abstract BigDecimal getDiscount(BigDecimal total);
}
