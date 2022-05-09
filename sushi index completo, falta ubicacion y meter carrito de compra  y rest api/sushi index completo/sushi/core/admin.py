from django.contrib import admin
from .models import Usuarios,Repartidores,Pedidos
# Register your models here.

#Permite administrar el modelo completo 

admin.site.register(Usuarios)
admin.site.register(Repartidores)
admin.site.register(Pedidos)
