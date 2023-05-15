var arr = [0, 1, 2];
var num;
function fibonacci(num) {
    if (num <= 3) {
        return arr;
    }
    else {
        for (var i = 3; i < num; i++) {
            arr.push((arr[i - 1] + arr[i - 2]));
        }
        return arr;
    }
}
num = 6;
fibonacci(num).forEach(function (value) { return console.log(value); });
var sum = 0;
for (var i = 0; i < num; i++) {
    sum += fibonacci(num)[i];
}
console.log(sum);
