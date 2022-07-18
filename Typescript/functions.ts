function func(y?: number, x: number = 2) {
  // console.log("Hello World")
  if (y === undefined) return x;
  return x + y;
}
function fun1(z=2,x?:number,y=1,...arr: number[]) {
  for (let x of arr) {
    console.log(x);
  }
}
let m = func(7);
// console.log(m);
fun1(1, 2, 3);
