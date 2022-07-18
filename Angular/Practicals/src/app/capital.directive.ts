import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appCapital]',
})
export class CapitalDirective {
  constructor(private er: ElementRef) {}
  @HostListener('blur') onBlur() {
    this.er.nativeElement.value=this.er.nativeElement.value.toUpperCase();
  }
}
