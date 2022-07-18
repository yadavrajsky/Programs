class Rect {
  constructor(public x?: number, public y?: number) {}
  print()
  {
    console.log(this.x,this.y);
  }
}
class R extends Rect {
  constructor(public m: number,public n: number) {
    super(m, n);
  }
  print()
  {
      console.log(this.m +" "+this.n+" "+this.x+" "+this.y);
      super.print();
  }
}
let rt = new R(20,30);
rt.print();