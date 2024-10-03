from django.db import models
from django.core.validators import MinValueValidator

class Producto(models.Model):
    nombre = models.CharField(max_length=100, blank=False)
    descripcion = models.TextField()
    precio = models.DecimalField(max_digits=10, decimal_places=2, validators=[MinValueValidator(0.01)])
    cantidad_en_stock = models.IntegerField(validators=[MinValueValidator(1)])
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.nombre