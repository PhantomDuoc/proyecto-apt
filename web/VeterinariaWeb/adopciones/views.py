from django.shortcuts import render, redirect
from .models import enAdopcion
from .forms import AdopcionForm

class Persona:
    def __init__(self, nombre, edad):
        self.nombre=nombre
        self.edad=edad
        super().__init__()

# Create your views here.
def home(request):
    mascotas = enAdopcion.objects.all()
    datos = {
        'enAdopcion':mascotas,
        'form':AdopcionForm()
    }
    return render(request, 'adopciones/index.html', datos)

def contacto(request):
    return render(request, 'adopciones/contacto.html')

def dashboard(request):
    mascotas = enAdopcion.objects.all()
    mascotas = enAdopcion.objects.order_by('idRescatado')
    datos = {
        'enAdopcion':mascotas,
        'form':AdopcionForm()
    }
    return render(request, 'adopciones/dashboard.html', datos)

def conocenos(request):
    return render(request, 'adopciones/conocenos.html')

def adopciones(request):
    mascotas = enAdopcion.objects.all()
    datos = {
        'enAdopcion':mascotas
    }
    return render(request, 'adopciones/adopciones.html', datos)

def form_adopcion(request):
    datos = {
        'form':AdopcionForm()
    }
    if(request.method == 'POST'):
        formulario = AdopcionForm(request.POST, request.FILES)
        if formulario.is_valid():
            formulario.save()
            datos['mensaje'] = 'Guardado correctamente'
    return render(request,'adopciones/form_adopciones.html', datos)

def form_mod_adopcion(request, id):
    mascota = enAdopcion.objects.get(idRescatado=id)

    datos = {
        'form':AdopcionForm(instance=mascota)
    }

    if(request.method == 'POST'):
        formulario = AdopcionForm(data=request.POST, instance=mascota)
        if formulario.is_valid():
            formulario.save()
            datos['mensaje'] = 'Modificado correctamente'

    return render(request, 'adopciones/form_mod_adopciones.html', datos)

def form_del_adopcion(request, id):
    mascota = enAdopcion.objects.get(idRescatado=id)
    mascota.delete()

    return redirect(to='home')

def login_screen(request):
    return render(request, 'adopciones/login.html')