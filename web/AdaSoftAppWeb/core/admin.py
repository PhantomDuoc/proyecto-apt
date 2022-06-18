from django.contrib import admin
from .models import Usuarios,Pedidos
# Register your models here.

#Permite administrar el modelo completo 

admin.site.register(Usuarios)
admin.site.register(Pedidos)
