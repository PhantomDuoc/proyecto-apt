from django import forms
from django.forms import ModelForm
from .models import Pedidos, Producto, Usuarios

class ObraForm(ModelForm):


    class Meta:
        model = Usuarios
        fields =['idUsuario','nameUsuario','contraseña','correo','telefono','direccion']  

        model = Producto
        fields = ['idCombo','NombreCombo','Precio']

        model = Pedidos
        fields = ['idPedido','IdUsuario']