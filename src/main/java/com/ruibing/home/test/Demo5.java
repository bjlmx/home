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

import com.ruibing.home.domain.Book;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Baijl
 * 2020/10/3
 * 16:22
 * @description
 */
public class Demo5 {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book(1, "轰隆隆老师");
        books.add(book1);
        Book book2 = new Book(1, "轰隆隆老师");
        books.add(book2);
        System.out.println(book1.equals(book2));
        books.forEach(System.out::println);
        Stream.of("mai","esq","idjv").map(String::toLowerCase).collect(Collectors.toList()).forEach(System.out::println);

        Stream.of(book1,book2).map(Book::getBookName).collect(Collectors.toList()).forEach(System.out::println);
    }

}
