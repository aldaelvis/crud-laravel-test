from django import forms
from .models import Producto

class ProductoForm(forms.ModelForm):
    class Meta:
        model = Producto
        fields = ['nombre', 'descripcion', 'precio', 'cantidad_en_stock']
        widgets = {
            'nombre': forms.TextInput(attrs={'class': 'form-control', 'required': 'required'}),
            'descripcion': forms.Textarea(attrs={'class': 'form-control'}),
            'precio': forms.NumberInput(attrs={'class': 'form-control', 'min': '0.01', 'required': 'required'}),
            'cantidad_en_stock': forms.NumberInput(attrs={'class': 'form-control', 'min': '1', 'required': 'required'}),
        }
