/**
 * Created by wth on 2017/5/2.
 */
//var data_shouru_zhanbi = [9.1, 14.38, 7.01, 2.26, 5.24, 7.63];  //收入同比
//var data_zhichu_zhanbi = [22.2, -9.17, 3.97, 7.05, 13.14, 9.13];   //支出同比
//var data_shouru = [346.39, 200.84, 305.59, 235.77, 260.27, 315.31]; //收入
//var data_zhichu = [562.72,375.29,604.29,443.84,768.31,518.33];  //支出
var data_shouru_zhanbi = [9.21,36.03,29.18,14.72,15.07,14.09];  //收入同比
var data_zhichu_zhanbi = [18.67,29.35,10.35,14.68,18.08,15.35];   //支出同比
var data_shouru = [3873626,5269408,6806929,7808952,8985395,10251696]; //收入
var data_zhichu = [6009694,7773767,8578696,9838477,11617542,13400433];  //支出
function test(arr){
    var arr1 = [];
    for(var i = 0; i < arr.length; i++) {
        arr1.push({
            coord: [i, arr[i]]
        });
    }
    return arr1;
}
option = {
    title : {
        text: '成都市地方财政收入支出基本情况'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:[
            {
                name:'收入'
            },
            {
                name:'支出'
            },
            {
                name:'收入同比增长'
            },
            {
                name:'支出同比增长'
            }


        ]
    },
    //toolbox: {
    //    show : true,
    //    feature : {
    //        dataView : {show: true, readOnly: false},
    //        magicType : {show: true, type: ['line', 'bar']},
    //        restore : {show: true},
    //        saveAsImage : {show: true}
    //    }
    //},
    calculable : true,
    xAxis : [
        {
            type : 'category',
            name : '年份',
            data : ['2009','2010','2011','2012','2013','2014']
        }
    ],
    yAxis : [
        {
            name:'万元',
            type : 'value'
        }
    ],

    series : [
        {
            //lable:{
            //    normal:{
            //        show : true
            //    }
            //},
            itemStyle : { normal: {label : {show: true, position: 'inside'}}},
            name: '收入',
            type: 'bar',
            data: data_shouru,

            markPoint: {
                symbolSize : 70,
                label: {
                    normal: {
                        formatter: function (param) {
                            return data_shouru_zhanbi[param['dataIndex']] + '%'
                        }
                    },
                    textStyle:{
                        fontSize: 1
                        }
                },
                data:test(data_shouru)
            }
        },
        {
            itemStyle : { normal: {label : {show: true, position: 'inside'}}},
            name:'支出',
            type:'bar',
            data:data_zhichu,
            markPoint : {
                symbolSize : 70,
                label: {
                    normal: {
                        formatter: function (param) {
                            return data_zhichu_zhanbi[param['dataIndex']] + '%'
                        }
                    }
                },
                data :test(data_zhichu)
            }
        }
    ]
};

