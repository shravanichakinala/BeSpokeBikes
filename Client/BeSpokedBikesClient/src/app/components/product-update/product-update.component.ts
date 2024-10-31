import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  product: any = {};

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
   // const id = +this.route.snapshot.paramMap.get('id');
    const id = +(this.route.snapshot.paramMap.get('id') || 0);  // Fetch ID from route

    this.productService.getAllProducts().subscribe(products => {
      this.product = products.find(p => p.id === id);
    });
  }

  updateProduct(): void {
    this.productService.updateProduct(this.product.id, this.product).subscribe(() => {
      this.router.navigate(['/products']);
    });
  }


  cancel(): void {
    this.router.navigate(['/products']);
  }
}
