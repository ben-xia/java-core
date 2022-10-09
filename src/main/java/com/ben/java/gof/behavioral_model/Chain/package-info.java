/**
 * @author ben-xia
 * @date 2019/10/30
 * @Description 责任链模式【Chain of Responsibility Pattern】
 *
 * 以上讲解的就是责任链模式，你看Father、Husband、Son 这三个类的处理女性的请求时是不是在传递
 * 呀，每个环节只有两个选项：要么承担责任做出回应，要么向下传递请求，最终会有环节做出回应;
 *
 * 责任链模式屏蔽了请求的处理过程，你发起一个请求到底是谁处理的，这个你不用关心，只要你把请
 * 求抛给责任链的第一个处理者，最终会返回一个处理结果（当然也可以不做任何处理），作为请求者可以不
 * 用知道到底是需要谁来处理的，这是责任链模式的核心；同时责任链模式也可以做为一种补救模式来使用，
 * 举个简单例子，如项目开发的时候，需求确认是这样的：一个请求（比如银行客户存款的币种），一个处理
 * 者（只处理人民币），但是随着业务的发展（改革开放了嘛，还要处理美元、日元等等），处理者的数量和
 * 类型都有所增加，那这时候就可以在第一个处理者后面建立一个链，也就是责任链来处理请求，你是人民
 * 币，好，还是第一个业务逻辑来处理，你是美元，好，传递到第二个业务逻辑来处理，日元，欧元…，这
 * 些都不用在对原有的业务逻辑产生很大改变，通过扩展实现类就可以很好的解决这些需求变更的问题。
 * 责任链有一个缺点是大家在开发的时候要注意：调试不是很方便，特别是链条比较长，环节比较多的
 * 时候，由于采用了类似递归的方式，调试的时候逻辑可能比较复杂。
 *
 *
 * 还有一个问题需要和大家说明一下，观察者模式也可以实现请求的传递，比如一个事件发生了，通知
 * 了观察者，同时观察者又作为一个被观察者，通知了另外一个观察者，这也形成了一个事件广播链，这和
 * 我们今天讲的责任链是有区别的：
 * 受众数量不同。观察者广播链式可以1：N 的方式广播，而责任链则要求是的1:1 的传递，必然有一个
 * 且只有一个类完成请求的处理；
 * 请求内容不同。观察者广播链中的信息可以在传播中改变，但是责任链中的请求是不可改变的；
 * 处理逻辑不通。观察者广播链主要用于触发联动动作，而责任链则是对一个类型的请求按照既定的规
 * 则进行处理。
 *
 *
 *
 *
 **/
package com.ben.java.gof.behavioral_model.Chain;