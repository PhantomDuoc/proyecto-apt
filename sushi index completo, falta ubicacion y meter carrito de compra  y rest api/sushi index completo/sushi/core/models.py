from msilib.schema import Class
from django.db import models


# Create your models here.

# USUARIOS / REPARTIDORES / PEDIDOS

##############################################
#           USUARIOS            #

class Usuarios(models.Model):
    idUsuario = models.IntegerField(primary_key=True, verbose_name="Id usuario")
    nameUsuario= models.CharField(max_length=7, verbose_name="Nombre usuario")
    contraseña=models.CharField(max_length=7, verbose_name="Contraseña usuario")
    correo=models.CharField(max_length=7, verbose_name="Correo usuario")
    telefono=models.IntegerField(max_length=8, verbose_name="Telefono usuario")
    direccion=models.CharField(max_length=50,verbose_name="Direccion usuario")

    def __str__(self):
        return self.nameUsuario

class Repartidores(models.Model):
    idRepartidor = models.IntegerField(primary_key=True, verbose_name="Id repartidor")
    nameRepartidor= models.CharField(max_length=7, verbose_name="Nombre repartidor")
    contraseña=models.CharField(max_length=7, verbose_name="Contraseña repartidor")
    correo=models.CharField(max_length=7, verbose_name="Correo repartidor")
    telefono=models.IntegerField(max_length=8, verbose_name="Telefono repartidor")
    direccion=models.CharField(max_length=50,verbose_name="Direccion repartidor")

    def __str__(self):
        return self.nameRepartidor

class Pedidos(models.Model):
    idPedido=models.IntegerField(primary_key=True, verbose_name="Id Pedido")
    numPedido=models.IntegerField(max_length=20, verbose_name="Num Pedido")
 
    def __str__(self):
        return self.numPedido