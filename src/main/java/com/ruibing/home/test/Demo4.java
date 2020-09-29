/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.test;

import com.ruibing.home.domain.BankAccountQuery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/** @author Baijl
 * 2020/9/28 
 * 15:15 
 * @description
 */
public class Demo4 {
    public static void main(String[] args) {

        ArrayList<BankAccountQuery> bankAccountQueries = new ArrayList<>();
        BankAccountQuery a = new BankAccountQuery("1", "A");
        BankAccountQuery b = new BankAccountQuery("1", "K");
        BankAccountQuery c = new BankAccountQuery("2", "G");
        BankAccountQuery d = new BankAccountQuery("2", "K");
        BankAccountQuery e = new BankAccountQuery("3", "D");
        bankAccountQueries.add(a);bankAccountQueries.add(b);bankAccountQueries.add(c);bankAccountQueries.add(d);
        bankAccountQueries.add(e);
        priviteFunction3(bankAccountQueries);
    }

    private static void priviteFunction3(ArrayList<BankAccountQuery> bankAccountQueries) {
        //先去重
        ArrayList<BankAccountQuery> collect = bankAccountQueries
                .stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BankAccountQuery::getTradeAcco))), ArrayList::new
                        )
                );
        //要返回的结果集
        ArrayList<BankAccountQuery> bankAccountQueriesNew = new ArrayList<>();
        //for (BankAccountQuery bankAccountQuery : collect) {
        //    for (BankAccountQuery accountQuery : bankAccountQueries) {
        //        if(accountQuery.getTrade_acco().equals(bankAccountQuery.getTrade_acco())&&"K".equals(accountQuery.getCapital_mode())){
        //            bankAccountQueriesNew.add(accountQuery);
        //        }
        //    }
        //
        //
        //}
        for (BankAccountQuery bankAccountQuery : bankAccountQueries) {
            if("K".equals(bankAccountQuery.getCapitalMode())){
                    bankAccountQueriesNew.add(bankAccountQuery);
                }
        }
        //ArrayList<BankAccountQuery> center = new ArrayList<>();
        //bankAccountQueriesNew.forEach(x->{
        //    collect.forEach(y->{
        //        if(!x.getTrade_acco().equals(y.getTrade_acco())){
        //            center.add(y);
        //        }
        //    });
        //});
        //bankAccountQueriesNew.addAll(center);
        //去重后的id集合
        List<String> collect1 = collect.stream().map(BankAccountQuery::getTradeAcco).collect(Collectors.toList());
        //结果集的id集合（这时还差一些单独的没有添加）
        List<String> collect2 = bankAccountQueriesNew.stream().map(BankAccountQuery::getTradeAcco).collect(Collectors.toList());
        //差值
        ArrayList<String> strings = new ArrayList<>();
        //这个循环是把去重后的id中没有在bankAccountQueriesNew添加的那些单独集合拿出来
        for (String s : collect1) {
            if(!collect2.contains(s)){
                strings.add(s);
            }
        }
        //这个集合放的是去重集合中有的但是在结果集中还没有的
        ArrayList<BankAccountQuery> queries = new ArrayList<>();
        //再次遍历去重后的集合
        for (BankAccountQuery bankAccountQuery : collect) {
            //获取到去重集合中差值的那个集合的记录
            for (String string : strings) {
                if(bankAccountQuery.getTradeAcco().equals(string)){
                    queries.add(bankAccountQuery);
                }
            }
        }
        //两个集合合并
        bankAccountQueriesNew.addAll(queries);
        System.out.println(bankAccountQueriesNew);

    }

}
