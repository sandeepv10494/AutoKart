import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SimilaraccessoriesComponent } from './similaraccessories.component';

describe('SimilaraccessoriesComponent', () => {
  let component: SimilaraccessoriesComponent;
  let fixture: ComponentFixture<SimilaraccessoriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SimilaraccessoriesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SimilaraccessoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
