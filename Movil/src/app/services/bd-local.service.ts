import { Injectable } from '@angular/core';
import { Storage } from '@ionic/storage';
import { INombre } from '../interfaces/inombre';
import { ToastController } from '@ionic/angular';

@Injectable({
  providedIn: 'root'
})
export class BdLocalService {

  storageLocal: INombre[]=[];

  private _storage: Storage | null=null;
  constructor(private storage: Storage, private toastController:ToastController) {
    this.Init();
    this.cargarStorageLocal();
   }
  async Init() {
    const storage=await this.storage.create();  
    this._storage=storage; 
  }
  async cargarStorageLocal(){
    const miStorageLocal= await this.storage.get('datos');
    if(miStorageLocal){
      this.storageLocal=miStorageLocal;
    }
  }
  guardarStorageLocal(strEstoy:string, strVoy:string){
    const existe=this.storageLocal.find(a=>a.strEstoy==strEstoy);
    if(!existe){
      this.storageLocal.unshift({strEstoy:strEstoy, strVoy:strVoy})
      this._storage.set('datos', this.storageLocal);
      this.presentToast("Registro agreagado con Exito!!")
    }
    else{
      this.presentToast("Registro YA EXISTE!!")
    }
  }

  async presentToast(msg: string) {
    const toast = await this.toastController.create({
      message: msg,
      duration: 3000
    });
    toast.present();
  }
}