from multiprocessing import context
from urllib import response
from django.shortcuts import render
from django.template import RequestContext
import requests
from core.models import Usuarios

urlUsers='http://localhost:8091/v1/departamento/gerencia/usuario/findAll'
urlProductos='http://localhost:8090/v1/departamento/gerencia/producto/findAll?size=6'





# Create your views here.
def index(request):
    response = requests.get(urlProductos).json() #Obteniendo datos productos 
    contextprod = response['content'] #obtenemos el contenido de la respuesta
    # imagen = contextprod[0].imagen
    print(contextprod)
    return render(request,'core/index.html', {'contextprod': contextprod}) #contenido hacia la vista





    
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
    response = requests.get(urlProductos).json()  #obtenemos la respuesta de la api
    context = response['content'] #obtenemos el contenido de la respuesta
    return render(request, 'core/inventario.html', {'context': context})  #enviamos el contenido a la vista

def ventas(request):
    return render(request, 'core/ventas.html')    

def logadm(request):
    return render(request, 'core/logadm.html')    

def usuarios(request):
    response = requests.get(urlUsers).json()  #obtenemos la respuesta de la api
    contextuser = response['content'] #obtenemos el contenido de la respuesta
    return render(request, 'core/usuarios.html', {'contextuser': contextuser})    

def perfil(request):
    # response = requests.get(urlPerfil).json()  #obtenemos la respuesta de la api
    # contextperfil = response['content'] #obtenemos el contenido de la respuesta
    return render(request, 'core/perfil.html')

# def repartidores(request):
#     return render(request, 'core/repartidores.html')    
    
# def administradores(request):
#     return render(request, 'core/administradores.html')        
