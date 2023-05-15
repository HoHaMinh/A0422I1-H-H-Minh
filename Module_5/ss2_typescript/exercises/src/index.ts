let arr: number[] = [0,1,2]
let num:number

function fibonacci(num) {
    if (num<=3) {
        return arr
    } else {
        for (let i=3; i<num; i++) {
            arr.push((arr[i-1] + arr[i-2]))
        }
        return arr
    }
}
num=6
fibonacci(num).forEach(value =>console.log(value))

let sum:number =0

for (let i=0; i<num;i++) {
    sum+=fibonacci(num)[i]
}
console.log(sum)
