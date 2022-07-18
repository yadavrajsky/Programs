class Demo
{
constructor(private x:number,private y:number)
{

}
    public get X()
    {
        return this.x;
    }
    
    public set X(v : number) {
        this.x = v;
    }
    
    public set Y(v : number) {
        this.y = v;
    }
    
    public get Y() : number {
        return this.y;
    }
    
    print()
    {
        console.log("x=",this.x,"y=",this.y);
    }
    
}
var obj=new Demo(1,2);
obj.X=10;
obj.Y=20;
console.log(obj.X,obj.Y);