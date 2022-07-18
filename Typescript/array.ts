let arr:number[]=[1,2,3];
let brr:Array<number>=[9,10];
let crr;
crr=[10,"Ram",true,1.5];
arr=arr.slice(0,2);
crr=crr.splice(1);
console.log(crr);
console.log(arr);