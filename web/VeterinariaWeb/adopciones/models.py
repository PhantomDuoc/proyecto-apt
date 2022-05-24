from django.db import models

# Create your models here.

class EstadoAdopcion(models.Model):
    estado_id = models.IntegerField(primary_key=True, verbose_name='ID Estado')
    estado = models.CharField(max_length=50, verbose_name='Nombre del estado de la adopcion')

    def __str__(self):
        return self.estado


class enAdopcion(models.Model):
    idRescatado = models.IntegerField(primary_key=True, verbose_name='ID del animal rescatado dado en adopcion', unique=True)
    nombre = models.CharField(max_length=50, verbose_name='Nombre', default='Sin nombre')
    especie = models.CharField(max_length=50, verbose_name='Especie', default='Sin especie')
    raza = models.CharField(max_length=50, verbose_name='Raza', default='Sin raza')
    descripcion = models.CharField(max_length=50, verbose_name='Descripcion', default='Sin descripcion')
    edad = models.CharField(max_length=2, verbose_name='Edad', default='Sin edad')
    estado_id = models.ForeignKey(EstadoAdopcion, on_delete=models.CASCADE)
    imagen = models.ImageField(upload_to="adopciones", null=True)

    def __str__(self):
        return self.nombre