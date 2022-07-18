import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
})
export class HighlightDirective {
  @Input() appHighlight='purple';
  constructor(private ref: ElementRef) {}
  @HostListener('mouseenter') onMouseEnter() {
    this.highlight(this.appHighlight);
  }
  @HostListener('mouseleave') onMouseLeave() {
    this.highlight('');

  }
  highlight(clr:string) {
    this.ref.nativeElement.style.backgroundColor =clr;

  }
}
