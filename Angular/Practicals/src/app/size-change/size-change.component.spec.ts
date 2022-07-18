import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SizeChangeComponent } from './size-change.component';

describe('SizeChangeComponent', () => {
  let component: SizeChangeComponent;
  let fixture: ComponentFixture<SizeChangeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SizeChangeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SizeChangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
