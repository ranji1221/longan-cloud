package org.ranji.lemon.game;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.scene.debug.Arrow;
import com.jme3.system.AppSettings;
import com.jme3.util.BufferUtils;

/**
 * 第一个Java 3D游戏
 * @author RanJi
 * 
 */
public class HelloMesh extends SimpleApplication{
	
	
	public static void main(String[] args) {
		//-- 配置参数
		AppSettings settings = new AppSettings(true);
		settings.setTitle("一个方块");	//-- 标题
		settings.setResolution(1366, 768);	//-- 分辨率
		
		//-- 启动JME3程序
		HelloMesh app = new HelloMesh();
		app.setSettings(settings);	//-- 应用参数
		app.setShowSettings(false);		//-- 阻止配置参数的窗口出现
		//-- app.setDisplayFps(false);
		//-- app.setDisplayStatView(false);
		app.start();
	}
	
	@Override
	public void simpleInitApp() {
		//-- 设置摄像头的位置
		cam.setLocation(new Vector3f(4.893791f, 4.5420675f, 9.626116f));
        cam.setRotation(new Quaternion(-0.031222044f, 0.9664778f, -0.14307737f, -0.21089031f));
        flyCam.setMoveSpeed(10);
		
		
		createHex();
		createArrow(new Vector3f(5, 0, 0), ColorRGBA.Green);
		createArrow(new Vector3f(0, 5, 0), ColorRGBA.Red);
		createArrow(new Vector3f(0, 0, 5), ColorRGBA.Blue);
	}
	
	/**
	 * 创建六边形
	 */
	private void createHex(){
		//-- 六个定点
		float[] vertex = {
			2.5f,4f,0f,		//-- 零
			1f,3.26f,0f,	//-- 壹
			1f,1.74f,0f,	//-- 贰
			2.5f,1f,0f,		//-- 叁
			4f,1.74f,0f,	//-- 肆
			4f,3.26f,0f		//-- 伍
		};
		
		//-- 四个三角形的索引
		int[] indices = new int[]{
			0,1,2,	//-- 三角形0
			2,3,4,	//-- 三角形1
			4,5,0,	//-- 三角形2
			0,2,4	//-- 三角形3
		};
		
		//-- 创建网格
		Mesh mesh = new Mesh();
		//-- 保存顶点位置和顶点索引
		mesh.setBuffer(Type.Position, 3, BufferUtils.createFloatBuffer(vertex));
		mesh.setBuffer(Type.Index, 1, BufferUtils.createIntBuffer(indices));
		
		mesh.updateBound();		//-- 更新边界
		mesh.setStatic();		//-- 设为静态模型
		
		//-- 创建材质，使我们可以看见这个六边形
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		
        //-- 创建物体使用网格和材质
        Geometry geom = new Geometry("六边形");
        geom.setMesh(mesh);
        geom.setMaterial(mat);
        geom.center();	//-- 默认的位置居中
        
		//-- 将物体添加到场景图中
		rootNode.attachChild(geom);
	}
	/**
	 * 创建一个箭头
	 * @param vec3	箭头向量
	 * @param color	箭头颜色
	 */
	private void createArrow(Vector3f vec3, ColorRGBA color){
		//-- 创建材质，设定箭头的颜色
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        
        //-- 创建几何物体，应用箭头网格。
        Geometry geom = new Geometry("arrow", new Arrow(vec3));
        geom.setMaterial(mat);

        // 添加到场景中
        rootNode.attachChild(geom);
	}
}
