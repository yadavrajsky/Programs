console.log("Hello World");
var x: number = 10;
var y:string="akash";
y=<string><any>20;
// y=(x as any) as string;
// y=(x as unknown) as string;
y=(x as any) as string;
// y=(x as undefined) as string;
// console.log(y);
// console.log(typeof y);
// console.log(typeof x);
var z=undefined;
console.log(x+y);
// let arr[][]=[]
var c=function hello()
{
console.log("Hello");
}
console.log(typeof c);
