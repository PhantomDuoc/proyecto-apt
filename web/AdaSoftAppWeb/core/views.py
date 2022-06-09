from multiprocessing import context
from urllib import response
from django.shortcuts import render
from django.template import RequestContext
import requests
from core.models import Usuarios

urlUsers='http://localhost:8091/v1/departamento/gerencia/usuario/findAll'
urlProductos='http://localhost:8091/v1/departamento/gerencia/producto/findAll'


# Create your views here.
def index(request):
    return render(request,'core/index.html')





    
def login(request):  #login
    response = requests.get(urlUsers).json()  #obtenemos la respuesta de la api
    context = response['content'] #obtenemos el contenido de la respuesta
    return render(request, 'core/login.html', {'context': context})  #enviamos el contenido a la vista




def registro(request):
    return render(request,'core/registro.html')

#put crear




def quienes(request):
    return render(request,'core/quienes.html')

def ubicacion(request):
    return render(request,'core/ubicacion.html')

def evento(request):
    return render(request,'core/evento.html')

def indexlog(request):
    return render(request,'core/indexlog.html')

def quieneslog(request):
    return render(request,'core/quieneslog.html')

def ubicacionlog(request):
    return render(request,'core/ubicacionlog.html')

def eventolog(request):
    return render(request,'core/eventolog.html')    

def dashboard(request):
    response = requests.get(urlProductos).json()  #obtenemos la respuesta de la api
    context = response['content'] #obtenemos el contenido de la respuesta
    return render(request, 'core/dashboard.html', {'context': context})  #enviamos el contenido a la vista

def estadistica(request):
    return render(request, 'core/estadistica.html')


def inventario(request):
    return render(request, 'core/inventario.html')

def ventas(request):
    return render(request, 'core/ventas.html')    

def logadm(request):
    return render(request, 'core/logadm.html')    




