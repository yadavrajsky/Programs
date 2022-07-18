import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwdbipComponent } from './twdbip.component';

describe('TwdbipComponent', () => {
  let component: TwdbipComponent;
  let fixture: ComponentFixture<TwdbipComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TwdbipComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TwdbipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
