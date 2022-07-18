interface Shape
{
    x:number;
    y:number;
    display():void;
}
class Rhombus implements Shape
{
    // public x:number;
    // public y:number;
constructor(public x:number,public y:number)
{

}
display():void {
    console.log(this.x,this.y);
}

}
// let o=new Rhombus(10,20);
// console.log(o.x);
// console.log(o.y);
// o.display();
function getDetails(obj:{x:number;y:number}):void
{
    console.log(obj.x,obj.y);
}
getDetails(new Rhombus(10,20));