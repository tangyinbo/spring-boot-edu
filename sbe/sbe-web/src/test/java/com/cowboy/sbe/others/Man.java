package com.cowboy.sbe.others;/**
 * Created by Administrator on 2017/11/13/0013.
 */

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-13 15:58
 **/
public class Man extends  Human {
    public static void main(String[] args) {
        System.out.println(Man.class.isInstance(new Human()));
    }
}
