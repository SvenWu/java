/**
 * Created by wth on 2017/4/16.
 */
//var data = [
//    [10.0, 8.04],
//    [8.0, 6.95],
//    [13.0, 7.58],
//    [9.0, 8.81],
//    [11.0, 8.33],
//    [14.0, 9.96],
//    [6.0, 7.24],
//    [4.0, 4.26],
//    [12.0, 10.84],
//    [7.0, 4.82],
//    [5.0, 5.68]
//];
var data = [
    [5,7],
    [3,12],
    [4,11],
    [8,16],
    [10,24],
    [15,34]
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
var newx = [];
var len = 9;  // 测试点间隔
for(var i = 0; i <= len; i++){
    newx[i] = min + (max-min)*i/len;
}
var data2 = [];
var n = x.length;
var a = [];
var m =3;
function polyFit(x, y, n, a, m) {
    var i, j, k;
    var z, p, c, g, q = 0, d1, d2;
    var s = new Array(20);
    var t = new Array(20);
    var b = new Array(20);
    var dt = new Array(3);
    for (i = 0; i <= m - 1; i++) {
        a[i] = 0.0;
    }
    if (m > n) {
        m = n;
    }
    if (m > 20) {
        m = 20;
    }
    z = 0.0;
    for (i = 0; i <= n - 1; i++) {
        z = z + x[i] / (1.0 * n);
    }
    b[0] = 1.0;
    d1 = 1.0 * n;
    p = 0.0;
    c = 0.0;
    for (i = 0; i <= n - 1; i++) {
        p = p + (x[i] - z);
        c = c + y[i];
    }
    c = c / d1;
    p = p / d1;
    a[0] = c * b[0];
    if (m > 1) {
        t[1] = 1.0;
        t[0] = -p;
        d2 = 0.0;
        c = 0.0;
        g = 0.0;
        for (i = 0; i <= n - 1; i++) {
            q = x[i] - z - p;
            d2 = d2 + q * q;
            c = c + y[i] * q;
            g = g + (x[i] - z) * q * q;
        }
        c = c / d2;
        p = g / d2;
        q = d2 / d1;
        d1 = d2;
        a[1] = c * t[1];
        a[0] = c * t[0] + a[0];
    }
    for (j = 2; j <= m - 1; j++) {
        s[j] = t[j - 1];
        s[j - 1] = -p * t[j - 1] + t[j - 2];
        if (j >= 3)
            for (k = j - 2; k >= 1; k--) {
                s[k] = -p * t[k] + t[k - 1] - q * b[k];
            }
        s[0] = -p * t[0] - q * b[0];
        d2 = 0.0;
        c = 0.0;
        g = 0.0;
        for (i = 0; i <= n - 1; i++) {
            q = s[j];
            for (k = j - 1; k >= 0; k--) {
                q = q * (x[i] - z) + s[k];
            }
            d2 = d2 + q * q;
            c = c + y[i] * q;
            g = g + (x[i] - z) * q * q;
        }
        c = c / d2;
        p = g / d2;
        q = d2 / d1;
        d1 = d2;
        a[j] = c * s[j];
        t[j] = s[j];
        for (k = j - 1; k >= 0; k--) {
            a[k] = c * s[k] + a[k];
            b[k] = t[k];
            t[k] = s[k];
        }
    }
    dt[0] = 0.0;
    dt[1] = 0.0;
    dt[2] = 0.0;
    for (i = 0; i <= n - 1; i++) {
        q = a[m - 1];
        for (k = m - 2; k >= 0; k--) {
            q = a[k] + q * (x[i] - z);
        }
        p = q - y[i];
        if (Math.abs(p) > dt[2]) {
            dt[2] = Math.abs(p);
        }
        dt[0] = dt[0] + p * p;
        dt[1] = dt[1] + Math.abs(p);
    }
    return a;
}
 a = polyFit(x,y,n,a,m);   //a是多项式参数

function average(x) {
        var ave = 0;
        var sum = 0;
        if (x !== null) {
            for (var i = 0; i < x.length; i++) {
                sum += x[i];
            }
            ave = sum / x.length;
        }
        return ave;
    }
 var avgx = average(x);    //x的平均值
function getY(x, avgx, a, m) {
        var y = 0;
        var l = 0;
        for (var i = 0; i < m; i++) {
            l = a[0];
            if (i > 0) {
                y += a[i] * Math.pow((x - avgx), i);
            }
        }
        return (y + l);
    }
function newdata(newx){
    for(var i = 0; i <= len; i++){
        var newy = [];
        newy[i] = getY(newx[i],avgx,a,m);
        data2.push([newx[i],newy[i]]);

        //data.push({x:newx[i],y:getY(newx[i],avgx,a,m)});
    }
    return data2;
}
data2 = newdata(newx);
