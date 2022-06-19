from django.shortcuts import render
import requests

AdminUsers="http://localhost:8091/v1/departamento/gerencia/usuario/findByType/0"
ClientUsers="http://localhost:8091/v1/departamento/gerencia/usuario/findByType/1"
DeliverUsers="http://localhost:8091/v1/departamento/gerencia/usuario/findByType/2"
# Create your views here.
def home(request):
    return render(request, 'core/home.html')

def login(request):
    return render(request, 'core/login.html')

def dashboard(request):
    return render(request, 'core/dashboard.html')


def usuarios(request):
    responseAdmins = requests.get(AdminUsers).json()  #obtenemos la respuesta de la api
    contextAdmins = responseAdmins['content'] #obtenemos el contenido de la respuesta
    responseClients = requests.get(ClientUsers).json()  #obtenemos la respuesta de la api
    contextClients = responseClients['content'] #obtenemos el contenido de la respuesta
    responseDelivers = requests.get(DeliverUsers).json()  #obtenemos la respuesta de la api
    contextDelivers = responseDelivers['content'] #obtenemos el contenido de la respuesta

    return render(request, 'core/usuarios.html', {'contextAdmins': contextAdmins, 'contextClients': contextClients, 'contextDelivers': contextDelivers})