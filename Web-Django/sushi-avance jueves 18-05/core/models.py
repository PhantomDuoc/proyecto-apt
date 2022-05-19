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

class Producto(models.Model):
     idCombo = models.IntegerField(primary_key=True, verbose_name="Id Combo")
     NombreCombo= models.CharField(max_length=20, verbose_name="Nombre Combo")
     Precio=models.IntegerField(max_length=7, verbose_name="Cantidad Combo")
#     arraylist<materiales> ingredientes
     
     def __str__(self):
        return self.NombreCombo

class Pedidos(models.Model):
    idPedido=models.IntegerField(primary_key=True, verbose_name="Id Pedido")
    idUsuario = models.ForeignKey(Usuarios, on_delete=models.CASCADE)
#   arraylist<producto> productos 
 
    def __str__(self):
        return self.numPedido