from django import forms
from django.db.models import fields
from django.forms import ModelForm
from .models import enAdopcion

class AdopcionForm(ModelForm):
    class Meta:
        model = enAdopcion
        fields = ['idRescatado','nombre','especie','raza','descripcion','edad','estado_id','imagen']