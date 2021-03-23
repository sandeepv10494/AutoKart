import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PricefilterComponent } from './pricefilter.component';

describe('PricefilterComponent', () => {
  let component: PricefilterComponent;
  let fixture: ComponentFixture<PricefilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PricefilterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PricefilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
