/**
 * Created by wth on 2017/4/8.
 */
var data = [
        [10.0, 8.04],
        [8.0, 6.95],
        [13.0, 7.58],
        [9.0, 8.81],
        [11.0, 8.33],
        [14.0, 9.96],
        [6.0, 7.24],
        [4.0, 4.26],
        [12.0, 10.84],
        [7.0, 4.82],
        [5.0, 5.68]
];
var x = [];
var y = [];
var max = 0;
var min = data[0][0];
for(var i = 0;i<data.length;i++)
{
    max = Math.max(data[i][0],max);
    min = Math.min(data[i][0],min);
    x.push(data[i][0]);
    y.push(data[i][1]);
}

function linearRegression(y, x) {

    var lr = {};
    var n = y.length;
    var sum_x = 0;
    var sum_y = 0;
    var sum_xy = 0;
    var sum_xx = 0;
    var sum_yy = 0;

    for (var i = 0; i < y.length; i++) {
        sum_x += x[i];
        sum_y += y[i];
        sum_xy += (x[i] * y[i]);
        sum_xx += (x[i] * x[i]);
        sum_yy += (y[i] * y[i]);
    }

    lr['slope'] = (n * sum_xy - sum_x * sum_y) / (n * sum_xx - sum_x * sum_x);
    lr['intercept'] = (sum_y - lr.slope * sum_x) / n;
    lr['r2'] = Math.pow((n * sum_xy - sum_x * sum_y) / Math.sqrt((n * sum_xx - sum_x * sum_x) * (n * sum_yy - sum_y * sum_y)), 2);

    return lr;

}

//function linearRegression(x,y)
//{
//    var lr= {};
//    var xmean = 0;
//    var ymean = 0;
//    for(var i = 0; i < x.length; i++)
//    {
//        xmean += x[i];
//        ymean += y[i];
//    }
//    xmean /= x.length;
//    ymean /= x.length;
//
//    var sumx2 = 0;
//    var sumxy = 0;
//    for(var i = 0; i < x.length; i++)
//    {
//        sumx2 += (x[i] - xmean) * (x[i] - xmean);
//        sumxy += (y[i] - ymean) * (x[i] - xmean);
//    }
//
//    lr['slope']= sumxy / sumx2;
//    lr['intercept']= ymean - lr.slope*xmean;
//
//}

var lr = linearRegression(y,x);

var markLineOpt = {
    animation: false,
    label: {
        normal: {
            formatter: 'y = '+lr.slope+'*x +'+lr.intercept,
            textStyle: {
                align: 'right'
            }
        }
    },
    lineStyle: {
        normal: {
            type: 'solid'
        }
    },
    tooltip: {
        formatter: 'y = '+lr.slope+'*x +'+lr.intercept
    },
    data: [[{
        coord: [min, lr.slope*min+lr.intercept],
        symbol: 'none'
    }, {
        coord: [max, lr.slope*max+lr.intercept],
        symbol: 'none'
    }]]
};

option = {
    title: {
        text: 'Anscombe\'s quartet',
        x: 'center',
        y: 0
    },
    grid: [
        {x: '7%', y: '7%'},
    ],
    tooltip: {
        formatter: 'Group {a}: ({c})'
    },
    xAxis: [
        {gridIndex: 0, min: 0},
    ],
    yAxis: [
        {gridIndex: 0, min: 0},
    ],
    series: [
        {
            name: 'I',
            type: 'scatter',
            xAxisIndex: 0,
            yAxisIndex: 0,
            data: data,
            markLine: markLineOpt
        }
    ]
};