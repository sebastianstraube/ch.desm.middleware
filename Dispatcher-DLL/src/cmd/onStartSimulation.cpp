#include <stdafx.h>

#include <jni.h>

#include "Desm.h"
#include "Middleware.h"
#include "util/JavaJni.h"

extern "C" {
	__declspec(dllexport) int stw_onStartSimulation()
	{
		if(!desm::Middleware::get().sendCommand(desm::ENUM_CMD_STARTSIMULATION)) {
			return desm::ERROR_API_MISUSE;
		}
		return desm::ERROR_OK;
	}

	JNIEXPORT void JNICALL Java_ch_desm_Dll_onStartSimulation(JNIEnv* env, jobject obj)
	{
		desm::util::jni::checkReturnCode(env, stw_onStartSimulation());
	}
};
