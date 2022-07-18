class Rectangle
{
    l:number=10;
    w: number;
    i:number=8;
    area()
    {
        console.log(this.l*this.w);
    }
    constructor(x:number,public h:number)
    {
        this.w=h;
    }
    volume()
    {
        console.log(this.l*this.w*this.h);
    }

}

let r=new Rectangle(20,30);
console.log(r.i);
console.log(r.h);
r.area();
r.volume();