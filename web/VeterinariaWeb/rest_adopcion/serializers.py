from rest_framework import serializers
from adopciones.models import enAdopcion, EstadoAdopcion

class AdopcionSerializer(serializers.ModelSerializer):
    class Meta:
        model = enAdopcion
        fields = ['idRescatado', 'nombre','especie','raza','descripcion','edad','estado_id','imagen']

class EstadoSerializer(serializers.ModelSerializer):
    class Meta:
        model = EstadoAdopcion
        fields = ['estado_id','estado']