import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserorderitemsComponent } from './userorderitems.component';

describe('UserorderitemsComponent', () => {
  let component: UserorderitemsComponent;
  let fixture: ComponentFixture<UserorderitemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserorderitemsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserorderitemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
