from django.shortcuts import render

from core.models import Usuarios



# Create your views here.
def index(request):
    return render(request,'core/index.html')
    
def login(request):
    return render(request,'core/login.html')
    
def registro(request):
    return render(request,'core/registro.html')

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
    return render(request, 'core/dashboard.html')

def estadistica(request):
    return render(request, 'core/estadistica.html')


def inventario(request):
    return render(request, 'core/inventario.html')

def ventas(request):
    return render(request, 'core/ventas.html')    

def logadm(request):
    return render(request, 'core/logadm.html')    




